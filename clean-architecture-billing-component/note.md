See https://reflectoring.io/java-components-clean-boundaries/
See https://github.com/thombergs/code-examples/tree/master/spring-boot/boundaries

See https://github.com/thombergs/fortune-cookie-shop


The billing component exposes an invoice calculator to the outside. The invoice calculator generates an invoice for a certain customer and time period.

For the invoice calculator to work, it needs to synchronize data from an external order system in a daily batch job. This batch job pulls the data from an external source and puts it into the database.

billing component has three sub-components: the invoice calculator, the batch job, and the database code. The invoice calculator is a public component and the batch job and database components are internal components that should not be accessible from outside of the billing component.
