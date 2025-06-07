# Panier API - Application de Gestion de Panier d'Achat

## Description
API REST Spring Boot pour la gestion d'un panier d'achat dans un mini e-commerce. Cette application permet de gérer 
des produits et un panier d'achat avec décrément automatique du stock.

## Fonctionnalités

### Gestion des Produits
- ✅ CRUD complet sur les produits (Créer, Lire, Mettre à jour, Supprimer)
- ✅ Recherche de produits par nom
- ✅ Filtrage des produits en stock
- ✅ Gestion automatique des stocks

### Gestion du Panier
- ✅ Ajouter un produit au panier (par ID)
- ✅ Supprimer un produit du panier
- ✅ Afficher tous les produits du panier avec total général
- ✅ Mettre à jour la quantité d'un produit dans le panier
- ✅ Vider complètement le panier
- ✅ Décrément automatique du stock lors de l'ajout au panier
- ✅ Restauration du stock lors de la suppression du panier

## Technologies Utilisées
- **Java 17**
- **Spring Boot 3.2.0**
- **Spring Data JPA**
- **Spring Boot Validation**
- **Base de données H2** (en mémoire)
- **Swagger/OpenAPI 3** pour la documentation
- **Maven** pour la gestion des dépendances

## Structure du Projet

```
src/main/java/com/example/panierapi/
├── PanierApiApplication.java          # Classe principale
├── controller/
│   ├── ProductController.java         # Contrôleur REST pour les produits
│   └── CartController.java           # Contrôleur REST pour le panier
├── service/
│   ├── ProductService.java           # Logique métier des produits
│   └── CartService.java              # Logique métier du panier
├── repository/
│   ├── ProductRepository.java        # Repository JPA pour les produits
│   └── CartItemRepository.java       # Repository JPA pour le panier
├── entity/
│   ├── Product.java                  # Entité Produit
│   └── CartItem.java                 # Entité Article du panier
├── dto/
│   ├── CartResponse.java             # DTO pour la réponse du panier
│   └── AddToCartRequest.java         # DTO pour ajouter au panier
├── config/
│   └── OpenApiConfig.java            # Configuration Swagger
└── exception/
    └── GlobalExceptionHandler.java   # Gestionnaire global d'exceptions
```

## Installation et Démarrage

### Prérequis
- Java 17 ou supérieur
- Maven 3.6 ou supérieur

### Étapes de démarrage

1. **Cloner le projet**
   ```bash
   git clone <repository-url>
   cd panier-api
   ```

2. **Compiler le projet**
   ```bash
   mvn compile
   ```

3. **Lancer l'application**
   ```bash
   mvn spring-boot:run
   ```

4. **Accéder à l'application**
    - API: http://localhost:8080
    - Swagger UI: http://localhost:8080/swagger-ui.html
    - Console H2: http://localhost:8080/h2-console
        - JDBC URL: `jdbc:h2:mem:testdb`
        - Username: `sa`
        - Password: ``

## Endpoints API

### Produits (`/api/products`)

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | `/api/products` | Récupérer tous les produits |
| GET | `/api/products/{id}` | Récupérer un produit par ID |
| POST | `/api/products` | Créer un nouveau produit |
| PUT | `/api/products/{id}` | Mettre à jour un produit |
| DELETE | `/api/products/{id}` | Supprimer un produit |
| GET | `/api/products/in-stock` | Récupérer les produits en stock |
| GET | `/api/products/search?nom=...` | Rechercher des produits par nom |

### Panier (`/api/cart`)

| Méthode | URL | Description |
|---------|-----|-------------|
| GET | `/api/cart` | Récupérer le contenu du panier |
| POST | `/api/cart/add` | Ajouter un produit au panier |
| DELETE | `/api/cart/remove/{productId}` | Supprimer un produit du panier |
| PUT | `/api/cart/update/{productId}?quantity=...` | Mettre à jour la quantité |
| DELETE | `/api/cart/clear` | Vider le panier |

## Exemples d'utilisation

### Créer un produit
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{
    "nom": "Nouveau Produit",
    "prix": 99.99,
    "stock": 10,
    "description": "Description du produit"
  }'
```

### Ajouter un produit au panier
```bash
curl -X POST http://localhost:8080/api/cart/add \
  -H "Content-Type: application/json" \
  -d '{
    "productId": 1,
    "quantity": 2
  }'
```

### Récupérer le panier
```bash
curl -X GET http://localhost:8080/api/cart
```

## Fonctionnalités Avancées

- **Gestion des stocks**: Le stock est automatiquement décrémenté lors de l'ajout au panier
- **Validation**: Validation des données d'entrée avec messages d'erreur personnalisés
- **CORS**: Configuration CORS pour permettre les appels depuis un frontend
- **Documentation**: Documentation automatique avec Swagger/OpenAPI
- **Gestion des erreurs**: Gestionnaire global d'exceptions avec réponses appropriées
- **Base de données**: Données de test pré-chargées au démarrage

## Configuration

Le fichier `application.properties` contient toutes les configurations :
- Port du serveur
- Configuration de la base de données H2
- Paramètres JPA/Hibernate
- Configuration Swagger
- Paramètres CORS

## Tests

Pour lancer les tests :
```bash
mvn test
```

## Documentation API

Une fois l'application démarrée, la documentation interactive est disponible à :
- **Swagger UI**: http://localhost:8080/swagger-ui.html
- **OpenAPI JSON**: http://localhost:8080/api-docs

## Support