from https://rskupnik.github.io/framework-independence-with-hexagonal-architecture	
See https://fideloper.com/hexagonal-architecture
See https://github.com/rskupnik/pet-clinic-modular/tree/master
See http://gorodinski.com/blog/2012/04/14/services-in-domain-driven-design-ddd/
See https://github.com/citerus/dddsample-core
See https://beyondxscratch.com/2020/08/23/hexagonal-architecture-example-digging-a-spring-boot-implementation/

See https://blog.octo.com/hexagonal-architecture-three-principles-and-an-implementation-example/
See https://alistair.cockburn.us/hexagonal-architecture/
See https://reflectoring.io/spring-hexagonal/
See https://medium.com/@msandin/strategies-for-organizing-code-2c9d690b6f33
See https://martinfowler.com/bliki/PresentationDomainDataLayering.html

See https://dev.to/bertilmuth/implementing-a-hexagonal-architecture-1kgf

### Principles of Hexagonal Architecture

#### Principle: Separate User-Side, Business Logic and Server-Side

![](archi_hexa_en_00.webp)

#### Illustration: a small example of an application

![](archi_hexa_en_01.webp)

####  Principle: dependencies go inside

![](archi_hexa_en_02.webp)

#### Inside and outside

![](archi_hexa_en_03.png)

#### Principle: boundaries are isolated with interfaces

![](archi_hexa_en_04.png)

#### A Metaphor: Ports & Adapters

![](archi_hexa_en_05.png)

#### Another Metaphor: the Hexagone

![](archi_hexa_en_06.png)

#### Detail: Dependencies inversion on the right

![](archi_hexa_en_07.png)


![](archi_hexa_en_08.png)

![](archi_hexa_en_09.png)

#### Detail: Why an Interface on the left?

![](archi_hexa_en_10.webp)

#### Testing in Hexagonal Architecture

##### How to replace some code from the User-Side?

![](archi_hexa_en_11.webp)


##### How to replace some code of the Server-Side?

![](archi_hexa_en_12.webp)


!
