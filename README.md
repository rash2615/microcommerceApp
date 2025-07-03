# Micro Commerce Application

Ce projet est une application de microservices Spring Boot composée de trois services :
- **Order Service**
- **Customer Service**
- **Product Service**

Chaque service dispose de sa propre base de données PostgreSQL.

## Prérequis
- [Docker](https://www.docker.com/) et [Docker Compose](https://docs.docker.com/compose/)

## Lancement rapide

1. **Construire et démarrer tous les services** :
   ```bash
   docker-compose up --build
   ```
   (La première exécution peut prendre quelques minutes)

2. **Accéder aux services** :
   - Customer Service : [http://localhost:8081/api/customers](http://localhost:8081/api/customers)
   - Product Service : [http://localhost:8082/api/products](http://localhost:8082/api/products)
   - Order Service : [http://localhost:8083/api/orders](http://localhost:8083/api/orders)

## Authentification
Tous les endpoints `/api/customers/**` et `/api/products/**` sont protégés par Basic Auth :
- **Utilisateur** : `user`
- **Mot de passe** : `password`

## Exemple de requête protégée
```bash
curl -u user:password http://localhost:8081/api/customers
```

## Arrêter la stack
```bash
docker-compose down
```

## Structure du projet
```
customer-service/      # Microservice clients (Spring Boot)
product-service/       # Microservice produits (Spring Boot)
order-service/         # Microservice commandes (Spring Boot)
docker-compose.yml     # Orchestration multi-conteneurs
README.md              # Ce guide
```

## Notes
- Chaque service utilise sa propre base PostgreSQL (voir ports dans docker-compose.yml).
- Les services communiquent entre eux via HTTP (Feign Client pour Order → Customer).
- Pour modifier les identifiants ou la configuration, adaptez les variables d'environnement dans `docker-compose.yml`.
