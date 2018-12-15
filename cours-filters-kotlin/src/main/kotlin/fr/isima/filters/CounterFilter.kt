package fr.isima.filters

import java.util.concurrent.atomic.AtomicLong
import javax.servlet.*
import javax.servlet.annotation.WebFilter

/**
 * Filtre permettant de compter le nombre de requêtes.
 *
 *
 * A noter que l'utilisation de [System.out] est généralement interdite
 * dans les projets en production, et que les informations de ce type sont
 * écrites par exemple dans des fichiers de logs.
 *
 *
 * @author Benjamin
 */
@WebFilter("/*")
class CounterFilter(private val counter: AtomicLong = AtomicLong(0)) : Filter {

    override fun doFilter(req: ServletRequest, rep: ServletResponse, chain: FilterChain) {
        println("Nombre de requetes " + counter.incrementAndGet())
        chain.doFilter(req, rep)
    }

    internal fun getCounter() = counter.get()

    override fun init(arg0: FilterConfig) {}
    override fun destroy() {}
}
