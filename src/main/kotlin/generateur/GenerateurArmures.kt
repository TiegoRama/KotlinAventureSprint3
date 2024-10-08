package generateur
import model.item.Armure
import model.item.Qualite
import java.nio.file.Paths
import java.nio.file.Files
import qualites
import typearmure
class GenerateurArmures (val cheminfichierarmure : String){



    fun generer(): MutableMap<String, Armure> {
        val mapObjets = mutableMapOf<String, Armure>()

        // Lecture du fichier CSV, le contenu du fichier est stocké dans une liste mutable :
        val cheminCSV = Paths.get(this.cheminfichierarmure)
        val listeObjCSV = Files.readAllLines(cheminCSV)

        // Instance des objets :
        for (i in 1..listeObjCSV.lastIndex) {
            val ligneObjet = listeObjCSV[i].split(";")
            val cle = ligneObjet[0].lowercase()
            val objet = Armure(nom = ligneObjet[0],  description = ligneObjet[1], typeArmure = typearmure[ligneObjet[2]]!!,qualites[ligneObjet[3]]!!)
            mapObjets[cle] = objet
        }
        return mapObjets
    }
}