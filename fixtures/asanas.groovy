import co.soochow.Asanas
import co.soochow.AsanasType

fixture{
    asanasType1(AsanasType,
            title:"type1",
            visible:true)

    asanasType2(AsanasType,
            title:"type2",
            visible:true)

    asanas1(Asanas,
            title:"asanas1",
            name:"ananas1",
            type:asanasType1,
            imageUrl:"image url",
            instructions:"instructions1"
    )

    asanas2(Asanas,
            title:"asanas2",
            name:"asanas2",
            type:asanasType2,
            imageUrl:"image url",
            instructions:"instructions2"
    )
}