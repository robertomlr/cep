package petshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/cadastro")
public class Cadastro extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("nome");
		String idade = req.getParameter("idade");
		String cep = req.getParameter("cep");

		String resposta = "";
		try {
			resposta = requestCep(cep);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		String htmlDeResposta = "<html>" + "<h1> Parabéns Sr(a)" + name + "</h1>" + "<p>Encontramos seu endereço: "
				+ resposta + "</p>" + "</html>";

		PrintWriter writer = resp.getWriter();
		writer.write(htmlDeResposta);

	}

	private String requestCep(final String cep) throws Exception {
		URL url = new URL("http://localhost:8080/cep-aula/buscacep?cep=" + cep);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type", "application/json");

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer content = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		con.disconnect();
		System.out.println(content);
		return content.toString();
	}

	private void insereNoBancoOCep(String cep) throws SQLException {
		Endereco endereco = new Gson().fromJson(cep, Endereco.class);
		
		Connection connection = EnderecoDao.getConnection();

		String sql = "INSERT INTO CADASTRO (CEP, LOGRADOURO, COMPLEMENTO, BAIRRO, LOCALIDADE, UF, UNIDADE, IBGE, GUIA) VALUES (?,?,?,?,?,?,?,?,?)";

		PreparedStatement stmt = connection.prepareStatement(sql);

		stmt.setString(1, Endereco.getCep());
		stmt.setString(2, Endereco.getLogradouro());
		stmt.setString(3, Endereco.getComplemento());
		stmt.setString(4, Endereco.getBairro());
		stmt.setString(5, Endereco.getLocalidade());
		stmt.setString(6, Endereco.getUf());
		stmt.setString(7, Endereco.getUnidade());
		stmt.setString(8, Endereco.getIbge());
		stmt.setString(9, Endereco.getGuia());
		
		stmt.execute();

        connection.close();
        stmt.close();
        System.out.println("deu certo");
        
        Endereco teste = new Endereco();
        System.out.println(Endereco.getBairro());
		
	}

}
