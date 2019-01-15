package fr.isima.service

import java.util.concurrent.atomic.AtomicInteger

/**
 * Cette classe sert simplement à compter le nombre d'occurence d'opérations sur
 * les maths ou sur les string
 *
 * @author Benjamin
 */
class OperationCounter {

    private val mathOps = AtomicInteger(0)

    private val stringOps = AtomicInteger(0)

    /**
     * Compte la requête ou envoie une exception si elle n'est pas referencee.
     * La methode est thread safe mais le toString() peut etre different de la
     * valeur trouvee au moment ou le compteur comptait effectivement.
     *
     * @param opName
     * le nom complet de l'operation
     * @return une chaine contenant le toString de l'operationCounter
     */
    fun countRequest(opName: String): String {
        if (opName.startsWith("/maths")) {
            mathOps.getAndIncrement()
        } else if (opName.startsWith("/strings")) {
            stringOps.getAndIncrement()
        } else {
            throw IllegalArgumentException("Operation $opName inconnue")
        }
        return toString()
    }

    override fun toString(): String {
        return "Math ops : " + mathOps.get() + " and string ops " + stringOps.get()
    }
}
