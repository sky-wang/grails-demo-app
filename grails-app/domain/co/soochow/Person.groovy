package co.soochow

class Person {
    String name
    String sex
    String email
    Date dateCreated

    static constraints = {
        sex nullable:true
        email nullable:true
    }
}
