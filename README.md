# projet_technoweb

Bienvenue sur notre projet dans le cadre du cours Technologies Web que nous avons réalisé en 3ème année d'école d'ingénieurs ISIS

Cahier des charges : 
" On se propose de réaliser une application web J2EE, en respectant au mieux l'architecture MVC (DAO, JSP, Servlet).

On utilise la base de données "sample" fournie avec NetBeans.

Schéma de la base de données : les clients (CUSTOMER) passent des commandes (PURCHASE_ORDER), les commandes référencent des produits (PRODUCT), les produits appartiennent a des catégories (PRODUCT_CODE), les catégories sont associées à un taux de remise (DISCOUNT_CODE). Les clients sont localisés dans des zones géographiques (MICRO_MARKET).

L'application est destinée à deux catégories d'utilisateurs : Les clients et l'administrateur.

Pour les clients :

- Le client doit s'authentifier pour accéder à l'édition des bons de commandes.

La base sample ne contenant pas de mots de passe, on utilisera les champs suivants de la table CUSTOMER pour l'authentification :

    login : EMAIL
    password : CUSTOMER_ID

Une fois connecté, l'application doit permettre au client l'édition complète de ses commandes (ajout, modification, suppression).

Pour l'administrateur :

- L'administrateur s'authentifie en utilisant un login / password prédéfini dans l'application : 
  
 <pre> login : admin@admin   
 password : admin</pre>

Une fois authentifié, l'administrateur a accès à une série de tableaux de bord graphiques qui lui permettent de visualiser des statistiques sur les commandes saisies :

    Visualiser les chiffres d'affaire par catégorie d'article, en choisissant la période (date de début / date de fin) sur laquelle doit porter la statistique.
    Visualiser les chiffres d'affaire par zone géographique, en choisissant la période (date de début / date de fin) sur laquelle doit porter la statistique.
    Visualiser les chiffres d'affaire par client, en choisissant la période (date de début / date de fin) sur laquelle doit porter la statistique.

Pour l'affichage des graphiques, on utilisera la bibliothèque javascript Google Charts
Livrable

Vous devez fournir un projet maven, déposé sur un dépôt github partagé avec l'utilisateur bastide. Ce projet doit être téléchargeable par git clone et immédiatement exécutable sous netbeans.
Evaluation

Le projet sera évalué par une présentation orale en groupe :

    Démonstration
    Examen du code source
    Questions/Réponses collectives et individuelles
    
    
- Voici la liste des utilisateurs de notre base de données, avec leur mot de passe suivi de leur login :
<pre>
1   jumboeagle@example.com
2   www.new.example.com
25  www.wrencomp.example.com
3   www.smallbill.example.com
36  www.bobhostcorp.example.com
106 www.centralcomp.example.com
149 www.johnvalley.example.com
863 www.bignet.example.com
777 www.westv.example.com
753 www.parts@ford.example.com
722 www.bparts.example.com
409 www.oldmedia.example.com
410 www.nycompltd@repair.example.com

</pre>
----------

- Pour la réalisation des graphiques, nous avons utilisé Google Charts. 
    
- Côté framework css nous avons opté pour <i>Boostrap</i>, un classique.

--------------

REPARTITION DES RÔLES :

César s'est focalisé sur la partie Vue

Paul s'est occupé de la partie Modèle

Erwan s'est chargé de la partie Controlleur

# Mode d'emploi

Sur notre Web Market, vous pourrez donc vous identifier en tant que client et passer des commandes. Vos commandes pourrons être modifées ou supprimées.

<br> Lorsque vous editez ou supprimez une commande, vous serez soit débité ou remboursé de la somme de la commande.


<strong>Côté Admin</strong>

Ici vous pourrez visualiser toutes les statistiques concernant le chiffre d'affaire
