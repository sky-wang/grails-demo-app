package co.soochow

class Asanas {

    String title
    String name
    AsanasType type
    String imageUrl
    String link
    String instructions
    boolean visible

    static constraints = {
        link nullable:true, blank:true
    }

    static mapping = {
        instructions type: 'text'
    }

}
