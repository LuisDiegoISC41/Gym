package gimnasio;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;

public class Index {

    @FXML
    private ListView<String> listaClientes;

    @FXML
    private ListView<String> listaMembresiasVen;

    @FXML
    private ListView<String> listaClientes1; // Esta es la de "Salidas"

    @FXML
    public void initialize() {
        // --- CONFIGURACIÓN LISTA DE ENTRADAS ---
        configurarLista(listaClientes, "#1f2a2a", "white");
        listaClientes.getItems().addAll(
            "Miguel Flores",
            "Flavio Juárez",
            "Matias López",
            "Marta Ugalde",
            "Mariano Márquez"
        );

        // --- CONFIGURACIÓN LISTA DE MEMBRESÍAS VENCIDAS ---
        configurarLista(listaMembresiasVen, "#2a1515", "#ff6666");
        listaMembresiasVen.getItems().addAll(
            "José García",
            "Ana Martínez",
            "Carlos Ruiz"
        );

        // --- CONFIGURACIÓN LISTA DE SALIDAS ---
        configurarLista(listaClientes1, "#1a1f1f", "#aaaaaa");
        listaClientes1.getItems().addAll(
            "Roberto Gómez",
            "Lucía Fernández"
        );

        // Aplicar transparencia a todos los ListViews
        String transparentStyle = "-fx-background-color: transparent; -fx-control-inner-background: transparent; -fx-background-insets: 0;";
        listaClientes.setStyle(transparentStyle);
        listaMembresiasVen.setStyle(transparentStyle);
        listaClientes1.setStyle(transparentStyle);
    }

    /**
     * Método genérico para darle el estilo de "Card" a las celdas de cualquier lista
     */
    private void configurarLista(ListView<String> lista, String bgColor, String accentColor) {
        lista.setCellFactory(list -> new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setGraphic(null);
                    setStyle("-fx-background-color: transparent;"); // Quita el fondo de la celda vacía
                    return;
                }

                // Contenedor de la fila (Card)
                HBox card = new HBox(15);
                card.setAlignment(Pos.CENTER_LEFT);
                card.setStyle(
                    "-fx-background-color: " + bgColor + ";" +
                    "-fx-background-radius: 12;" +
                    "-fx-padding: 12;" +
                    "-fx-border-color: rgba(255,255,255,0.05);" +
                    "-fx-border-radius: 12;"
                );

                Label idLabel = new Label("#" + (int)(Math.random() * 9000 + 1000));
                idLabel.setStyle("-fx-text-fill: " + accentColor + "; -fx-opacity: 0.6;");
                idLabel.setPrefWidth(60);

                Label nombreLabel = new Label(item);
                nombreLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 14;");
                nombreLabel.setPrefWidth(180);

                Label fechaLabel = new Label("17/03/26");
                fechaLabel.setStyle("-fx-text-fill: #888888;");
                
                Region spacer = new Region();
                HBox.setHgrow(spacer, Priority.ALWAYS);

                Label icon = new Label("⚙");
                icon.setStyle("-fx-text-fill: #555555; -fx-font-size: 16;");

                card.getChildren().addAll(idLabel, nombreLabel, fechaLabel, spacer, icon);

                // Importante: quitar el color azul de selección por defecto de JavaFX
                setStyle("-fx-background-color: transparent; -fx-padding: 5 0 5 0;");
                setGraphic(card);
            }
        });
    }
}