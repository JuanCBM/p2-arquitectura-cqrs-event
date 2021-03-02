<h1 align="center">Práctica 2. Módulo Patrones y arquitecturas de servicios de internet 👨🏻‍💻 </h1>

<p align="center">
  <a href="/docs" target="_blank">
    <img alt="Documentation" src="https://img.shields.io/badge/documentation-yes-brightgreen.svg" />
  </a>
  <a href="#" target="_blank">
    <img alt="License: MIT" src="https://img.shields.io/badge/License-MIT-yellow.svg" />
  </a>
</p>

Proyecto para aplicar CQRS & Event Sourcing

## Authors

👤 **JuanCBM**: Juan Carlos Blázquez Muñoz

* Github: [@JuanCBM](https://github.com/JuanCBM)

👤 **mahuerta**: Miguel Ángel Huerta Rodríguez

* Github: [@mahuerta](https://github.com/mahuerta)

# Sobre la aplicación

Hemos utilizado eventos dentro de la aplicación Spring.

Adjuntamos un proyecto postman ``p2-arquitectura.postman_collection.json`` situado en la raíz del
proyecto para realizar las peticiones necesarias para probar la aplicación.

# Notas teóricas

Además de guardar el estado del carrito, se debe crear un evento ShoppingCartClosed (Los eventos se
ponen en pasado). Este evento debe publicarlo en un publisher ShoppingCartProcess y debe leerlo un
listener ReadModelUpdater. Ambos no se pueden localizar en la capa de dominio, puesto que son
dependientes de la tecnología. En este caso del framework de Spring.

Como hemos comentado son dependientes de la tecnología (ApplicationEventPublisher de spring),
deberemos inyectarlo como hacemos con el servicio externo de validación en un servicio a parte

EL procesador actualizará la vista (materialized view) de carritos completados con sus id-precio
total.

# Corrección

Los eventos deben mandar sólo el cambio, no el agregado completo.

Capa de servicios de spring entre el controller y el dominio para publicar eventos.


