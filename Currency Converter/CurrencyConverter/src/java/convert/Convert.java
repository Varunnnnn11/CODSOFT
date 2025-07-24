package convert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Convert")
public class Convert extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private Map<String, Double> exchangeRates;

    @Override
    public void init() {
        exchangeRates = new HashMap<>();
        // Example rates
        exchangeRates.put("USD_INR", 83.0);
        exchangeRates.put("INR_USD", 0.012);
        exchangeRates.put("USD_EUR", 0.91);
        exchangeRates.put("EUR_USD", 1.10);
        exchangeRates.put("USD_GBP", 0.78);
        exchangeRates.put("GBP_USD", 1.28);
        exchangeRates.put("INR_EUR", 0.011);
        exchangeRates.put("EUR_INR", 90.0);
        exchangeRates.put("INR_GBP", 0.0095);
        exchangeRates.put("GBP_INR", 105.0);
        exchangeRates.put("EUR_GBP", 0.86);
        exchangeRates.put("GBP_EUR", 1.16);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String from = request.getParameter("fromCurrency");
        String to = request.getParameter("toCurrency");
        String amountStr = request.getParameter("amount");

        try {
            if (from.equals(to)) {
                request.setAttribute("result", "No conversion needed. Same currencies selected.");
            } else {
                double amount = Double.parseDouble(amountStr);
                String key = from + "_" + to;

                if (exchangeRates.containsKey(key)) {
                    double rate = exchangeRates.get(key);
                    double converted = amount * rate;
                    String msg = String.format("%.2f %s = %.2f %s", amount, from, converted, to);
                    request.setAttribute("result", msg);
                } else {
                    request.setAttribute("error", "Conversion rate not available.");
                }
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid amount.");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
