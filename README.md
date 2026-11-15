# README — HAI704I TP 2 : Services web SOAP

*Agence de réservation et hôtels (SOAP / WSDL, Java)*


**Université de Montpellier — Master 1 Informatique (parcours ICO) — HAI704I Architectures logicielles distribuées — 2026-2027**

Étudiant : VAROL Serdar (travail individuel)

## 1. Le projet

### 1.1 Rôle des projets

L'application est composée de deux projets Maven indépendants, qui ne partagent aucune classe Java. Seul le contrat (WSDL + schéma XSD) est commun.

| Projet | Rôle | Approche |
|---|---|---|
| `source/hotel` | Service SOAP d'un hôtel : recherche d'offres et réservation authentifiée. Il est lancé deux fois (deux hôtels, deux ports). | *code-first* : les classes Java annotées produisent le WSDL |
| `source/agence` | Client : interroge tous les hôtels, agrège et trie les offres, réserve. Interface en ligne de commande. | *contract-first* : les classes clientes sont engendrées depuis une copie du WSDL |

### 1.2 Structure des sources

```
source/
  hotel/
    pom.xml
    src/main/java/hotel/
      Serveur.java              lanceur (port et hôtel en arguments)
      HotelPortImpl.java        point d'accès SOAP (seule classe qui connaît SOAP)
      contrat/                  types du contrat : HotelPort, Demande, Offre,
                                DemandeReservation, Paiement, Confirmation,
                                fautes AgenceInconnue, AuthentificationRefusee,
                                PaiementInvalide, OffreIndisponible
      service/                  logique métier sans SOAP : ServiceHotel, Chambre,
                                Proposition, Reservation, Authentification,
                                ValidationPaiement
      depot/                    ChambreDepot (interface), ChambreDepotMemoire
  agence/
    pom.xml
    src/main/wsdl/              hotel.wsdl, hotel.xsd (copie du contrat)
    src/main/java/agence/
      Console.java              couche 1 : interface console
      LogiqueAgence.java        couche 2 : logique de l'agence
      AccesSoap.java            couche 3 : accès SOAP (proxys, adresses, délais)
      OffreAgence.java, ErreurAgence.java   types propres à l'agence
      Agence.java               petit client non interactif (tests des étapes A4 à A6)
```

### 1.3 Dépendances et versions

| Élément | Version |
|---|---|
| JDK d'exécution | OpenJDK 21.0.12.1 (Homebrew) |
| Niveau de compilation (`maven.compiler.release`) | 17 |
| Maven | 3.10.0 |
| `com.sun.xml.ws:jaxws-rt` (Eclipse Metro, Jakarta XML Web Services 4.0, JAXB) | 4.0.5 |
| `org.codehaus.mojo:jaxws-maven-plugin` (wsimport, projet agence) | 4.0.5 |
| `org.codehaus.mojo:exec-maven-plugin` | 3.5.0 |

Toutes les dépendances sont téléchargées par Maven. Le code utilise l'espace de noms `jakarta.*` (sauf `javax.xml.datatype`, qui fait partie de Java SE).

### 1.4 Où et comment le client est engendré

La copie du contrat est dans `source/agence/src/main/wsdl/` (`hotel.wsdl` et `hotel.xsd`). Elle a été obtenue depuis un hôtel en marche (`http://localhost:8082/hotel?wsdl` et `?xsd=1`) ; l'attribut `schemaLocation` du WSDL a été remplacé par `hotel.xsd` pour que les deux fichiers soient lus en local. Le plugin `jaxws-maven-plugin` (objectif `wsimport`) engendre le paquetage `agence.gen` à chaque `mvn package`, dans `target/generated-sources/wsimport/`. Ces classes ne sont pas versionnées (elles se régénèrent).

Si le contrat de l'hôtel change, il faut recopier le WSDL et le XSD de la même manière avant de reconstruire l'agence.

### 1.5 Où se configure le secret de l'agence

Le secret n'est pas dans le code de l'agence : il est passé en paramètre de lancement (troisième argument de la console, voir § 2.4). Côté hôtel, seul un vérificateur (empreinte PBKDF2 salée, comparée en temps constant) est rangé ; les secrets de démonstration sont déclarés dans `hotel/service/Authentification.java` (limite assumée, voir § 4).

### 1.6 Organisation du client

Trois couches, une classe chacune :

1. `Console` : menu, saisies, affichage ; ne connaît ni proxy, ni classe engendrée, ni adresse.
2. `LogiqueAgence` : liste des hôtels, interrogation de tous, agrégation, tri par prix, réservation chez l'hôtel d'origine de l'offre choisie.
3. `AccesSoap` : seule classe qui utilise les classes engendrées (`agence.gen`), les adresses et les délais d'attente (connexion 2 s, réponse 3 s).

`OffreAgence` et `ErreurAgence` (qui distingue un refus métier d'une panne technique) sont les types échangés entre les couches.

### 1.7 Parties bonus

Aucune partie bonus (B1, B2, B3, C, D) n'a été réalisée.

### 1.8 Environnement de développement

macOS (Apple Silicon, `aarch64`), éditeur VS Code et terminal avec Maven en ligne de commande. Aucun IDE n'est nécessaire pour reconstruire : JDK 21 et Maven suffisent.

## 2. L'exécution

Les commandes ci-dessous se lancent depuis la racine de l'archive. Prévoir **trois fenêtres de terminal** : deux pour les hôtels (elles restent ouvertes), une pour l'agence. Dans chaque fenêtre, commencer par :

```
export JAVA_HOME=$(/usr/libexec/java_home -v 21)
```

(sous Linux, faire pointer `JAVA_HOME` vers un JDK 21.)

### 2.1 Construction (dans l'ordre)

```
cd source/hotel
mvn clean package

cd ../agence
mvn clean package
```

La construction de l'agence engendre `agence.gen` à partir de `src/main/wsdl/hotel.wsdl`.

### 2.2 Ordre de démarrage

D'abord les hôtels, ensuite l'agence.

Fenêtre 1 (hôtel A, port 8082) :

```
cd source/hotel
mvn -q exec:exec -Dexec.executable=java -Dexec.args="-cp %classpath hotel.Serveur 8082 A"
```

Fenêtre 2 (hôtel B, port 8083) :

```
cd source/hotel
mvn -q exec:exec -Dexec.executable=java -Dexec.args="-cp %classpath hotel.Serveur 8083 B"
```

Chaque hôtel affiche `Hotel X publie : http://localhost:<port>/hotel` puis l'adresse de son WSDL (`?wsdl`).

*Pourquoi `exec:exec` et non `exec:java` :* avec `exec:java`, Metro n'arrive pas à construire une faute SOAP (`ClassNotFoundException` sur `org.glassfish.jaxb.runtime.v2.ContextFactory`) et la réponse d'erreur HTTP 500 est vide. Avec `exec:exec`, le programme tourne dans une JVM séparée avec le classpath complet et les fautes sont correctes.

### 2.3 Ports, adresses et jeu de données fictif

| Hôtel | Port | Adresse du service | Chambres (toutes fictives) |
|---|---|---|---|
| A, « Hotel des Arenes » | 8082 | `http://localhost:8082/hotel` | CH-101 Montpellier 3 étoiles 2 lits 89,00 € ; CH-102 Montpellier 3 étoiles 3 lits 124,50 € ; CH-201 Montpellier 4 étoiles 2 lits 150,00 € ; CH-301 Sète 2 étoiles 2 lits 65,00 € |
| B, « Hotel du Port » | 8083 | `http://localhost:8083/hotel` | PT-101 Montpellier 4 étoiles 2 lits 110,00 € ; PT-102 Montpellier 3 étoiles 4 lits 95,00 € ; PT-201 Sète 3 étoiles 2 lits 70,00 € |

Prix par nuit. Les réservations sont gardées en mémoire : redémarrer un hôtel les efface.

Agences et tarifs (déclarés dans le code de l'hôtel, dans `ServiceHotel` et `Authentification`) :

| Agence | Secret de démonstration | Tarif |
|---|---|---|
| AG-42 | `secret-42` | prix nominal |
| AG-77 | `secret-77` | prix nominal moins 10 % |

Coordonnées de paiement fictives pour les essais : carte `4111111111111111`, expiration mois `12`, année `2030`, CVC `123`.

### 2.4 Lancement de l'agence (CLI)

Fenêtre 3 :

```
cd source/agence
mvn -q exec:exec -Dexec.executable=java -Dexec.args="-cp %classpath agence.Console http://localhost:8082/hotel,http://localhost:8083/hotel AG-42 secret-42"
```

Les trois arguments sont, dans l'ordre : la **liste des adresses des hôtels** séparées par des virgules (c'est là que se configurent les hôtels connus de l'agence : ajouter un hôtel ne demande aucune recompilation), l'**identifiant de l'agence** et son **secret**.

Menu :

```
1) rechercher un sejour
2) reserver une offre
0) quitter
```

Conventions de saisie :

- dates au format `AAAA-MM-JJ` (exemple : `2026-12-10`) ; le départ doit être postérieur à l'arrivée ;
- nombres de personnes, d'étoiles minimum, prix maximum, mois et année d'expiration : un entier chacun, **saisis séparément** (le mois `12`, puis l'année `2030`) ;
- le numéro d'offre est la position dans la liste affichée (1, 2, 3…), triée du moins cher au plus cher ;
- un champ vide, un nombre ou une date mal formés, un numéro hors liste sont refusés avec un message ; le programme ne s'arrête pas.

Un refus de l'hôtel s'affiche sous la forme `refus de l'hotel : …` (agence ou secret refusés, paiement invalide, offre indisponible). Un hôtel éteint ou injoignable est signalé en une ligne `! hotel injoignable : <adresse>` et les offres des autres hôtels s'affichent quand même. Le numéro de carte et le CVC ne sont ni réaffichés ni enregistrés ; seule la forme masquée (`**** 1111`) renvoyée par l'hôtel est montrée.

**Arrêt propre** : saisir `0` au menu (ou fermer l'entrée avec Ctrl+D). Les hôtels s'arrêtent avec Ctrl+C dans leur fenêtre.

### 2.5 Scénario minimal de vérification

1. Démarrer les deux hôtels puis l'agence AG-42 (§ 2.2 et 2.4).
2. `1` : ville `Montpellier`, arrivée `2026-12-10`, départ `2026-12-13`, `2` personnes, `3` étoiles minimum, prix maximum `400` : quatre offres de deux hôtels, de 267,00 € à 373,50 €.
3. `2` : offre `1`, nom et prénom, carte `4111111111111111`, `12`, `2030`, `123` : référence `RES-1`.
4. Redemander la même offre : `refus de l'hotel : offre indisponible`.
5. Relancer avec `AG-77 secret-77` : mêmes offres à des prix inférieurs de 10 %.
6. Relancer avec `AG-42 faux` : la recherche fonctionne, la réservation est refusée (`identifiants d'agence refuses`).
7. Arrêter l'hôtel B puis relancer : la recherche signale `hotel injoignable` et affiche les offres de l'hôtel A.

## 3. Autres éléments rendus

- `captures/` : WSDL, schéma, requêtes et réponses SOAP de recherche, de réservation et d'une faute métier (étape A7), capturés avec `curl`.
- `video/demonstration.mp4` : démonstration de l'application en fonctionnement (deux hôtels, recherche, comparaison de prix selon l'agence, réservation, refus métier, secret erroné, hôtel éteint, arrêt propre).
- `Compte-Rendu.pdf` : rapport d'ingénierie.

## 4. Limites connues

- Le secret circule en clair dans le message SOAP (ni HTTP ni l'enveloppe ne le protègent ; WS-Security n'est pas traité).
- Secrets de démonstration écrits dans le code de l'hôtel ; sel de l'empreinte dérivé de l'identifiant de l'agence plutôt qu'aléatoire.
- Réservations et agences en mémoire (perdues au redémarrage d'un hôtel).
- Interrogation des hôtels en séquence : un hôtel muet retarde la recherche de la durée du délai d'attente (3 s).
- Après une panne technique, un nouvel essai de réservation génère un nouvel identifiant de demande.
- Les propriétés de délai d'attente `com.sun.xml.ws.connect.timeout` et `com.sun.xml.ws.request.timeout` sont propres à l'implémentation Metro (elles ne figurent pas dans le cours).
