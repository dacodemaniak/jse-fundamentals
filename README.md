# Automatiser la production de requête

Les requêtes standard du SQL : **INSERT**, **UPDATE**, **DELETE**, **SELECT** sont
toujours bâties sur le même modèle.

A partir de ce constat, il doit être possible d'automatiser la production des
requêtes à partir d'un langage de programmation.

## Feuille de route

- **Etape 1** : A partir d'une classe "modèle" récupérer le nom de la future table,
- **Etape 2** : Lister tous les "attributs" de la classe "modèle" afin de les ranger dans une liste,
*Attention* Les attributs des classes sont donnés, selon la règle, en camelCase, or, les colonnes de la table sont donnés en snake_case ; penser à convertir d'une casse à une autre,
- **Etape 3** : Une fois le nom de la table récupéré et les attributs listés, produire une chaîne de caractères constituée des noms des colonnes, aliasés avec l'initiale du nom de la table, et séparés par des virgules,
- **Etape 4** : Terminer la requête en ajoutant *SELECT* devant la chaîne précédemment constituée, et *FROM* juste après cette chaîne, puis le nom de la table récupéré à l'**étape 1** avec son alias
*N'oubliez pas* de terminer votre chaîne avec ";"

**Exemple**

Soit le modèle Student suivant :

``id
lastName
firstName
email
phoneNumber
login
password``

La requête finale qui doit être produite devrait être :

    SELECT s.id, s.last_name,s.first_name,s.email,s.phone_number,s.login,s.password
    FROM student s;

## Comment procéder

Il est possible de traiter ce problème en TDD (Test Driven Development). Ce procédé doit nous permettre de traiter les problèmes l'un après l'autre en écrivant d'abord le test de ce qui doit être réalisé, et écrire ensuite le code minimum qui valide le test.

**Exemple**

    @Test
    @DisplayName("Should give 'student' from Student class")
    void shouldGiveTableName() {
        assertEquals("student", repository.getTableName());
    }

Une fois écrit le code qui valide ce test. On ajoute une contrainte, dans un autre test :

    @Test
    @DisplayName("Should give 'student s' from Student class")
    void shouldGiveAliasedTableName() {
        assertEquals("student s", repository.getAliasedTableName();
    }

Certains tests sont plus compliqués que d'autres à réaliser.

En effet, la récupération des "attributs" d'une classe se fait par une méthode particulière.

    class.getDeclaredFields()

Cependant cette méthode vous retournera les "attributs" sans ordre particulier.

Il faudra donc trier les attributs dans un certain ordre pour valider que vous avez récupéré TOUS les attributs.

    @Test
    @DisplayName("Should list all attributes")
    void shouldListAllAttributes() {
        String[] expectedFields = {"email", "firstName", "id", "lastName", "login", "password", "phoneNumber"};
        String[] fields = repository.getFields().sorted();
        assertTrue(expectedFields.equals(fields));
    }

Et ainsi de suite jusqu'à ce qu'on obtienne, pour une requête **SELECT** standard la chaîne suivante :

    SELECT s.id id, s.last_name lastName, s.first_name firstName, s.email email, s.phone_number phoneNumber, s.login login, s.password password
    FROM student s;

