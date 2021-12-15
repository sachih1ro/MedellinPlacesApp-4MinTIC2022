package com.example.medellinplaces.model

class PlaceProvider {
    companion object {

        private var actualPlaceId: Int = 0

        fun obtainActualPlaceId(): Int{
            return actualPlaceId
        }

        fun setPlaceId(value: Int) {
            this.actualPlaceId = value
        }

        fun getPlace(position: Int):PlaceModel{
            return places[position]
        }

        val places = listOf<PlaceModel>(
            PlaceModel("Jardín Botánico",
                "El Jardín Botánico \"Joaquín " +
                        "Antonio Uribe\" de Medellín es un museo vivo y centro de ciencia ubicado en " +
                        "la zona central de la ciudad. Es una área silvestre, protegida y de acceso " +
                        "público con una amplia diversidad de plantas y animales, que cuenta" +
                        " incluso con un lago.",
                "jardin_botanico",
                "4.5 / 5.0"),
            PlaceModel("Parque Explora",
                "Es un museo interactivo de ciencias conformado por multiples salas que" +
                        " incluyen un acuario con énfasis en la Amazonia, un planetario y un teatro.",
                "parque_explora",
                "5.0 / 5.0"),
            PlaceModel("Parque de los Deseos",
                "Ubicado cerca a la UdeA, es un parque urbano dentro del cual se " +
                        "encuentran el Planetario de Medellín \"Jesús Emilio Ramírez\" y la Casa de la Música.",
                "parque_deseos",
                "4.0 / 5.0"),
            PlaceModel("Parque Norte",
                "Es un parque de diversiones ubicando en el centro de la ciudad.",
                "parque_norte",
                "3.9 / 5.0")

        )
    }
}