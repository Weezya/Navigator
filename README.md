# Navigator
### by Weezya

![version](https://img.shields.io/badge/version-1.0.0-blue.svg)

- Application Mobile Android réalise avec Android Studio
- Navigateur de fragments et d'activités en Front-End
- Projet d'étude 4A à l'ESIEA encadré par M. VINCENT
- Approfondissement de bases de programmation mobile vues en 3A

## Table of Contents

* [Démonstration](#Démonstration)
* [Fonctionnalité détaillées de l'application](#Fonctionnalité-détaillées-de-l'application)
* [Design](#Design)
* [Catalogue d'activités et de fragments](#Catalogue-d'activités-et-de-fragments)
* [Démarche de développement Mobile](#Démarche-de-développement-Mobile)
* [Structuration du projet](#Structuration-du-projet)

## Démonstration

(Work in Progress)

## Fonctionnalité détaillées de l'application

Projet crée avec l’activité Navigation Drawer générée par Android Studio
Un menu avec 6 éléments : Home, Map, About, Pokedex, Gallery et Login
Deux activités complémentaires

- 3 Fragments fonctionnant dans l’activité Main : 
    - Home
        - Header avec barre de recherche factice (Work in Progress)
        - NestedScrollView + CardView + RelativeLayout + ...
        - Design : photos + icones + fonts + size + margin + color
    - Map
        - Généré avec Android Studio
        - Google API Service 
        - Création d'une clé API
                https://console.developers.google.com/?hl=FR
    - About
        - LinearLayout simple et efficace
        - Signature de l'application
        - Rappel des fonctionnalités

- 3 activités attachés au menu
    - Pokedex
        - Instance de Pokemon et Adapter pour chaque
        - Call de l'API avec Retrofit et conversion GSON
                https://pokeapi.co/api/v2/
        - Retrofit, Conversion GSON et Picasso avec accès Internet
        - Call d'une seconde API pour les images avec Glide
                https://pokeres.bastionbot.org/images/pokemon/
        - RecyclerView + AppBar/Toolbar + ...
        - Barre de recherche factice (Work in Progress)
        - Gestion de Layout avec une grille de 3 colonnes
        - Chargement par blocs de 20 avec le Scroll
    - Gallery
        - Hard coded data with Adapter : Name, Place, Description, Image
        - Adapter pour chaque élément de la liste
        - ListView + CardView + ConstraintLayout + CoordinatorLayout + ...
        - Bouton pour ajouter un élément factice (Work in Progress)
    - Login
        - Généré avec Android Studio
        - LinearLayout + EditText + Button + ...
        - Retourne une notification "Welcome back Satoshi" après connexion
        - Page d’enregistrement manquante
        - Boutons pour réseaux sociaux factice (Work in Progress)

- 1 activité lancée au démarrage de l'application
    - Splash
        - Animation appliquée au logo et au titre
        - Attente de 5 secondes pour laisser le chargement finir

- 1 activité lancée via Gallery
    - ItemData
        - Ouverture du détail lors de la sélection d'un élément dans Gallery
        - Utilisation d'un Intent pour traduire les données de la liste
        - CollapsingToolbarLayout + NestedScrollView + CardView + ...
        - Boutons Youtube et Share factices (Work in Progress)

## Design

Travail effectué tout au long du projet et à la fin pour les tests d'affichage
Le travail sur XML met parfois plus de temps que la programmation du Java
Différents éléments personnalisé et cherché sur Internet :
    - color + size + fonts
    - icones + photos + parallax
    - gradients + animations
    - agencement des couches

Découverte et expertise rapide des shimmer Facebook (Work in Progress)

## Catalogue d'activités et de fragments

(Work in Progress)

## Démarche de développement Mobile

Projet entièrement réalisé par Weezya
Beaucoup d'heures passés sur le projet durant 3 mois
Mixage de documentations, de tutoriels et de travaux personnels adaptatifs

Début
Navigation Drawer

Problèmes rencontrés en reprenant le projet de l'année dernière
Beaucoup de mises à jour de code nécessaires pour le refaire fonctionner

Il faut bien comprendre les dépendances et la configuration du projet avant de développer
Maîtriser son code pour le corriger facilement en cas d'erreurs ou de conflits

Beaucoup de problème résolus après avoir tourné en rond autour de la solution

Premier prototype d'application effectué pendant les vacances avec l'activité Navigation Drawer
Bien comprendre la différence entre un fragment et une activité avant de se lancer dans un nouveau projet au propre

Remarque : entre les systèmes Windows et Mac, Android Studio ne génère pas la même activité Navigation Drawer. Sur Mac on a une structure simple avec une seule activité et un menu à compléter soi-même alors que sur Windows il génère également chaque fragment

Pokedex
    - Reprise des éléments de l'ancien projet Pokedex pour appeler l'API et l'afficher dans sa RecyclerView

Map
    - Création facile et intuitive de l'activité Maps avec Android Studio 
    - Récupération d'une clé API sur le site de Google

Gallery
    - Partir à la conquête de sa propre liste écrite en dur
    - Afficher le détail de chaque élément dans une nouvelle activité

Home et Login
    - Plusieurs pirouettes et jeux de jambes sur clavier avec divers tutoriels
    - Beaucoup d'idées et de changements pour arriver à un produit final

About
    - Rappels des fonctionnalité et Signature de l'application


Remarque :  toujours faire un backup avant de faire des folies avec son code, soit tout le projet entre chaque grandes étapes soit des bouts de codes pour les changements partiels. Sublime Text est un très bon outil pour cela et il possède des codes couleurs pour s'y retrouver et comparer des lignes

## Structuration du projet

Architecture MVC (Model–View–Controller)
Beaucoup de ressources pour le design

```
├───App
│   │ 
│   ├───AndroidManifest
│   │   
│   ├───java.com.example.navigator
│   │   │  
│   │   ├───Models
│   │   │       LoggedInUser
│   │   │       LoggedInUserView
│   │   │       LoginFormeState
│   │   │       LoginResult
│   │   │       LoginViewModel
│   │   │       LoginViewModelFactory
│   │   │       Pokemon
│   │   │       PokemonRequest
│   │   │       
│   │   ├───Views
│   │   │       AboutFragment
│   │   │       HomeFragment
│   │   │       ItemdataActivity
│   │   │       ListActivity
│   │   │       LoginActivity
│   │   │       MainActivity
│   │   │       MapsFragment
│   │   │       PokedexActivity
│   │   │       SplashActivity
│   │   │       
│   │   ├───Controller    
│   │   │       LoginDataSource
│   │   │       LoginRepository
│   │   │       PokeAdapter
│   │   │       PokeapiService
│   │   │       Result
│   │   │       
│   │   └─── . . .
│   │   
│   └───res
│       │
│       ├───anim
│       │       transitionstart.xml
│       │       transitionstart2.xml
│       │
│       ├───drawable
│       │       *.jpg . . .
│       │       *.png . . .
│       │       *.xml . . .
│       │       gratient*.xml . . .
│       │       ic_*.xml . . .
│       │       menu_*.xml . . .
│       │       log_*.png . . .
│       │   
│       ├───drawable
│       │       atma_light.ttf
│       │       vibur.ttf
│       │       atma_medium.xml
│       │       atma.xml
│       │       alegreya_sans_sc_thin.xml
│       │       damion.xml
│       │       dosis_light.ttf
│       │       dosis.ttf
│       │       dosis_extralight.xml
│       │       aldrich.xml
│       │       advent_pro.xml
│       │   
│       ├───layout
│       │       activity_list.xml
│       │       activity_login.xml
│       │       activity_main.xml
│       │       activity_pokedex.xml
│       │       activity_splash.xml
│       │       fragment_about.xml
│       │       fragment_home.xml
│       │       fragment_maps.xml
│       │       home_features_grid.xml
│       │       list_item_data.xml
│       │       list_item_row.xml
│       │       main_nav_header.xml
│       │       pokedex_item.xml
│       │   
│       ├───menu
│       │       activity_main_drawer.xml
│       │       main.xml
│       │       
│       ├───mipmap
│       │       ic_*.png . . .
│       │       ic_*.xml . . .
│       │       log_*.png . . .
│       │   
│       └───values
│               colors.xml
│               dimens.xml
│               drawables.xml
│               font_certs.xml
│               google_maps_api.xml
│               ic_navigator_background.xml
│               preloaded_fonts.xml
│               strings.xml
│               styles.xml
│
└───Gradle
```
