/*
 * The MIT License
 *
 * Copyright 2020 DirectX-Box.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package fr.orleans.univ.pel.connexion;

import com.opensymphony.xwork2.ActionSupport;
import facade.FacadeParis;
import fr.orleans.univ.pel.support.PelActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 * Action de déconnexion.
 * 
 * Cette action déconnecte l'utilisateur.
 * 
 * @author DirectX-Box
 */
public class Deconnexion extends PelActionSupport {
    
    /**
     * La Map stockant les éléments de session.
     * 
     * Celle-ci est automatiquement créée via la méthode setSession(),
     * qui est fournie par l'interface SessionAware.
     */
    private Map<String, Object> session;
    
    /**
     * Le code de l'action.
     * 
     * Cette méthode est automatiquement appelée
     * par Struts 2 lorsque l'action est invoquée.
     * 
     * @return "success" si l'action a réussi, "input" sinon.
     */
    @Override
    public String execute()
    {
        FacadeParis modele = this.getModele();
        modele.deconnexion(this.pseudonyme);
        this.session.clear();
        return "success";
    }

    /**
     * Fixe la Map des variables de session.
     * 
     * Cette méthode est héritée de l'interface
     * SessionAware, et est automatiquement
     * appelée par Struts 2 lors de l'invocation
     * de l'action.
     * @param map la Map des variables de session.
     */
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }
    
}
