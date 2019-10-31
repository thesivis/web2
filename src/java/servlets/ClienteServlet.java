package servlets;

import entidades.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/cliente"})
public class ClienteServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Cliente c = new Cliente();
        c.setNome(request.getParameter("nome"));
        c.setCpf(request.getParameter("cpf"));
        c.setEmail(request.getParameter("email"));
        c.setTelefone(request.getParameter("telefone"));
        c.setGenero(request.getParameter("genero"));
        c.setEndereco(request.getParameter("endereco"));
        
        String dataStr = request.getParameter("dataNasc");
        
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            c.setDataNascimento(sdf.parse(dataStr));
        }catch(Exception erro){
            
        }
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ClienteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ClienteServlet at " + request.getContextPath() + "</h1>");
            out.println("Nome: "+c.getNome()+"<br/>");
            out.println("CPF: "+c.getCpf()+"<br/>");
            out.println("Email: "+c.getEmail()+"<br/>");
            out.println("Telefone: "+c.getTelefone()+"<br/>");
            out.println("Gênero: "+c.getGenero()+"<br/>");
            out.println("Endereço: "+c.getEndereco()+"<br/>");
            out.println("Data: "+c.getDataNascimento()+"<br/>");
            out.println("</body>");
            out.println("</html>");
        }
        
        List<Cliente> lista = (List<Cliente>)request
                .getSession()
                .getAttribute("lista");
        
        if(lista == null){
            lista = new ArrayList<Cliente>();
        }
        
        lista.add(c);
        request.getSession().setAttribute("lista", lista);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
