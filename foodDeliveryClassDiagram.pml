@startuml
hide empty description
class Driver {
name
startShiftTime
endShiftTime
currentOrder
county
isWorking() : boolean
}
class Restaurant {
name
address
county
openingHour
closingHour
List<Meal>
isOpen() : boolean
}
class Order {
restaurant
customer
dietaryRestriction
List<String> Meals
driver
creationTime
pickupTime
deliveryTime
setCreationTime()
setPickupTime()
setDeliveryTime()
}
class Customer {
name
address
county
dietaryRestriction
}
Order "1" o-- "1" Driver
Customer "1" *-- "*" Order
Order "1" o-- "1" Restaurant
@enduml