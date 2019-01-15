package fr.isima.filters

import javax.servlet.*
import javax.servlet.annotation.WebFilter

/**
 * Vérifie la présence ou non des parametres pour les opérations mathématiques
 *
 * @author Benjamin Kuchcik
 */
@WebFilter("/maths/*")
class MandatoryMathsOperatorFilter : Filter {


    override fun doFilter(req: ServletRequest, resp: ServletResponse, chain: FilterChain) {
        val a = req.getParameter("a")
        val b = req.getParameter("b")
        when {
            a == null && b == null -> throw ServletException("Membres a et b obligatoires")
            a == null -> throw ServletException("Membre a obligatoire")
            b == null -> throw ServletException("Membre b obligatoire")
            else -> chain.doFilter(req, resp)
        }
    }

    override fun destroy() {}

    override fun init(arg0: FilterConfig) {}

}
