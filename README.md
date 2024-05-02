# Optional Java 8

## Pourquoi Optional a été introduit en Java.

Optional a été introduit en Java pour résoudre le problème des valeurs nulles. Avant l'introduction d'Optional dans Java
8, de nombreux problèmes de programmation étaient liés à la manipulation de valeurs null, ce qui pouvait entraîner des
erreurs de NullPointerException à l'exécution.

Optional est une classe qui permet de représenter une valeur pouvant être présente ou absente. Elle force les
développeurs à être explicites sur la possibilité qu'une valeur puisse être absente, les obligeant à gérer ce cas dans
leur code. Cela encourage les bonnes pratiques de programmation et rend le code plus sûr en réduisant les risques
d'erreurs liées aux valeurs nulles.

En résumé, Optional a été introduit pour promouvoir la clarté du code, réduire les erreurs potentielles et encourager la
programmation défensive en Java.

## Comment Optional aide à éviter les NullPointerExceptions

Optional aide à éviter les NullPointerExceptions en encourageant une gestion explicite des valeurs potentiellement
nulles. Voici comment :

Forcer la vérification explicite : L'utilisation d'Optional oblige les développeurs à vérifier si une valeur est
présente ou absente avant de l'utiliser. Cela oblige à une réflexion consciente sur la possibilité qu'une valeur puisse
être absente, réduisant ainsi les chances de négligence qui conduisent souvent à des NullPointerExceptions.
Encourager les méthodes de récupération sûres : Plutôt que d'accéder directement à une valeur qui peut être nulle, les
développeurs sont encouragés à utiliser les méthodes d'Optional telles que isPresent(), ifPresent(), orElse(),
orElseGet(), etc., pour récupérer la valeur ou fournir une valeur par défaut si elle est absente.
Chainer les opérations de manière sûre : Optional fournit des méthodes fonctionnelles telles que map(), flatMap(),
filter(), etc., qui permettent de manipuler la valeur encapsulée de manière sûre, sans risque de NullPointerException,
en cas de valeur absente.
Clarifier l'intention du code : L'utilisation d'Optional rend le code plus expressif en indiquant clairement qu'une
valeur peut être absente et en fournissant des mécanismes pour traiter ce cas. Cela rend le code plus lisible et plus
facile à comprendre pour les autres développeurs.
En combinant ces avantages, Optional aide à rendre le code Java plus robuste et moins sujet aux erreurs liées aux
valeurs nulles, en encourageant les bonnes pratiques de programmation et en fournissant des mécanismes pour gérer de
manière sécurisée les valeurs potentiellement absentes.
