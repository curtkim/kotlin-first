//https://blog.jdriven.com/2022/04/optics-in-kotlin-with-arrow/
package book.functional_kotlin.ch12_arrow

import arrow.optics.Lens
import arrow.optics.optics


@optics
data class Person(val name: String, val city: City)
@optics
data class City(val name: String, val street: Street)
@optics
data class Street(val name: String)

val cityLens: Lens<Person, City> = Lens(
    get = { it.city },
    set = { person: Person, city: City -> person.copy(city = city) }
)

//City -> Street
val streetLens: Lens<City, Street> = Lens(
    get = { it.street },
    set = { city: City, street: Street -> city.copy(street = street) }
)

//Street -> name
val streetNameLens: Lens<Street, String> = Lens(
    get = { it.name },
    set = { street: Street, name: String -> street.copy(name = name) }
)

val personStreetNameLens = cityLens
    .compose(streetLens)
    .compose(streetNameLens)


fun main(args: Array<String>) {
    val person = Person("MyName", City("MyCity", Street("MyStreet")))
    println(person)

    val city: City = cityLens.get(person) //Get City property
    println(city)

    val modifiedCity = cityLens.modify(person) { //Modify City property
        c: City -> c.copy(name = "MyNewCity")
    }
    println(modifiedCity)

    val updatedStreetPerson = personStreetNameLens.modify(person) { "MyNewStreet" }
    println(updatedStreetPerson)


    //val updatedStreetPerson = Person.city.street.name.modify(person){"MyNewStreet"}
}