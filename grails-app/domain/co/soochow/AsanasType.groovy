package co.soochow

class AsanasType {

    String title
    String imageUrl
    boolean visible

    static hasMany = [asanas: Asanas]
    static belongsTo = [asanas: Asanas]

    static constraints = {
        imageUrl nullable:true, blank:true
    }
}
