# Property Management System Backend
This is a mock up backend for property management system that will enable agents on the client side to perform the tasks below. This backend is a monolithic application that uses
the spring boot framework and Java Persistence API. The Entity Relationship mappings are clearly illustrated as follows:

## Relationships
### @OneToOne
we have @OneToOne Relationship between Tenant and House entity as shown below:
```java
public class House {
  ...
    @OneToOne
    @JsonIgnore
    private Tenant tenant;
    ...
}
```
```java
public class Tenant {
   ...
    @OneToOne(mappedBy = "tenant", fetch = FetchType.EAGER)
    @JoinColumn(name = "house_id", referencedColumnName = "id")
    private House house;
}
```
### @OneToMany
We have @OneToMany Relationship between Client entity and Property entity
```java
public class Client {
    ...
    @OneToMany(mappedBy = "client", fetch = FetchType.EAGER)
    private List<Property>properties;
}
```
```java
public class Property {
    ...
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client client;
  ...
}
```


## Tasks
- Add and View Properties from different clients
- Add House units of different sizes under different properties which includes the rent and deposit amount.
- Add Tenant and assign them to a vacant house.
- Get Tenants profile data.
- Get report list of all properties, clients and tenants
