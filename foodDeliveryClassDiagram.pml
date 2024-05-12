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
class FoodDeliveryApp {
List<Driver> drivers
List<Restaurant> restaurants
List<Customer> customers
List<Order> orders
}
FoodDeliveryApp "1" *-- "*" Driver
FoodDeliveryApp "1" *-- "*" Order
FoodDeliveryApp "1" *-- "*" Restaurant
FoodDeliveryApp "1" *-- "*" Customer
Order "1" o-- "1" Driver
Customer "1" o-- "*" Order
Order "1" o-- "1" Restaurant
@enduml