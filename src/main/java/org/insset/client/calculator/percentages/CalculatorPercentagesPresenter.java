package org.insset.client.calculator.percentages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PercentagesConverterService;
import org.insset.client.service.PercentagesConverterServiceAsync;
import org.insset.shared.FieldVerifier;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author talend
 */
public class CalculatorPercentagesPresenter extends Composite {

    @UiField
    public TextBox priceBeforeDiscount;
    @UiField
    public TextBox discountPercentage1;
    @UiField
    public SubmitButton boutonFinalPrice;
    @UiField
    public ResetButton boutonClearFinalPrice;
    @UiField
    public Label errorLabelFinalPrice;

    @UiField
    public TextBox finalPrice;
    @UiField
    public TextBox discountPercentage2;
    @UiField
    public SubmitButton boutonBasePrice;
    @UiField
    public ResetButton boutonClearBasePrice;
    @UiField
    public Label errorBasePrice;

    @UiField
    public TextBox dividend;
    @UiField
    public TextBox diviser;
    @UiField
    public SubmitButton boutonDivision;
    @UiField
    public ResetButton boutonClearDivision;
    @UiField
    public Label errorLabelDivision;

    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorPercentagesPresenter> { }

    private static CalculatorPercentagesPresenter.MainUiBinder ourUiBinder = GWT.create(CalculatorPercentagesPresenter.MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final PercentagesConverterServiceAsync service = GWT.create(PercentagesConverterService.class);

    /**
     * Constructeur
     */
    public CalculatorPercentagesPresenter() {
        initWidget(ourUiBinder.createAndBindUi(this));
        initHandler();
    }

    /**
     * Init des handler
     */
    private void initHandler() {
        boutonFinalPrice.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                calculateFinalPrice();
            }
        });
        boutonBasePrice.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                calculateBasePrice();
            }
        });
        boutonDivision.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                divide();
            }
        });

        boutonClearFinalPrice.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                priceBeforeDiscount.setText("");
                discountPercentage1.setText("");
                errorLabelFinalPrice.setText("");
            }
        });
        boutonClearBasePrice.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                finalPrice.setText("");
                discountPercentage2.setText("");
                errorBasePrice.setText("");
            }
        });
        boutonClearDivision.addClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                dividend.setText("");
                diviser.setText("");
                errorLabelDivision.setText("");
            }
        });
    }

    /**
     * Call server
     */
    private void calculateFinalPrice() {

        try {
            final int priceBeforeDiscountValue = Integer.parseInt(priceBeforeDiscount.getText());
            final int discountPercentage1Value = Integer.parseInt(discountPercentage1.getText());

            if (!FieldVerifier.isValidEnteredPrice(priceBeforeDiscountValue) || !FieldVerifier.isValidPercentage(discountPercentage1Value)) {
                errorLabelFinalPrice.addStyleName("serverResponseLabelError");
                errorLabelFinalPrice.setText("Format incorect");
                return;
            }
            service.calculateFinalPrice(priceBeforeDiscountValue, discountPercentage1Value, new AsyncCallback<Double[]>() {
                public void onFailure(Throwable caught) {
                    // Show the RPC error message to the user
                    // Window.alert(SERVER_ERROR);
                }

                public void onSuccess(Double[] result) {
                    errorLabelFinalPrice.setText(" ");
                    new DialogBoxInssetPresenter(
                            "Calcul du prix final",
                            "Prix avant réduction: " + ((double) Math.round(priceBeforeDiscountValue * 100) / 100)  + "€ | % de réduction: " + ((double) Math.round(discountPercentage1Value * 100) / 100) +"%",
                            "Prix apres réduction: " + ((double) Math.round(result[0] * 100) / 100)  + "€, vous avez economiser " + ((double) Math.round(result[1] * 100) / 100) +"€"
                    );
                }
            });
        } catch (NumberFormatException e) {
            errorLabelFinalPrice.addStyleName("serverResponseLabelError");
            errorLabelFinalPrice.setText("Format incorect");
            return;
        }
    }

    /**
     * Call server
     */
    private void calculateBasePrice() {

        try {
            final int finalPriceValue = Integer.parseInt(finalPrice.getText());
            final int discountPercentage2Value = Integer.parseInt(discountPercentage2.getText());

            if (!FieldVerifier.isValidEnteredPrice(finalPriceValue) || !FieldVerifier.isValidPercentage(discountPercentage2Value)) {
                errorBasePrice.addStyleName("serverResponseLabelError");
                errorBasePrice.setText("Format incorect");
                return;
            }
            service.calculateBasePrice(finalPriceValue, discountPercentage2Value, new AsyncCallback<Double[]>() {
                public void onFailure(Throwable caught) {
                    // Show the RPC error message to the user
                    // Window.alert(SERVER_ERROR);
                }

                public void onSuccess(Double[] result) {
                    errorBasePrice.setText(" ");
                    new DialogBoxInssetPresenter(
                            "Calcul du prix avant réduction",
                            "Prix avant réduction: " + ((double) Math.round(finalPriceValue * 100) / 100)  + "€, % de réduction: " + ((double) Math.round(discountPercentage2Value * 100) / 100) +"€",
                            "Prix apres réduction: " + ((double) Math.round(result[0] * 100) / 100)  + "€, economie: " + ((double) Math.round(result[1] * 100) / 100) + "€"
                    );
                }
            });

        } catch (NumberFormatException e) {
            errorBasePrice.addStyleName("serverResponseLabelError");
            errorBasePrice.setText("Format incorect");
            return;
        }

    }

    /**
     * Call server
     */
    private void divide() {

        try {
            final int dividendValue = Integer.parseInt(dividend.getText());
            final int diviserValue = Integer.parseInt(diviser.getText());

            if (!FieldVerifier.isValidDivisionOperands(dividendValue, diviserValue)) {
                errorLabelDivision.addStyleName("serverResponseLabelError");
                errorLabelDivision.setText("Valeurs non valides");
                return;
            }
            service.divide(dividendValue, (double) diviserValue, new AsyncCallback<Double>() {
                public void onFailure(Throwable caught) {
                    // Show the RPC error message to the user
                    // Window.alert(SERVER_ERROR);
                }

                public void onSuccess(Double result) {
                    errorLabelDivision.setText(" ");
                    new DialogBoxInssetPresenter(
                            "Division de 2 entiers",
                            dividendValue + " / " + diviserValue,
                            Double.toString(result)
                    );
                }
            });
        } catch (NumberFormatException e) {
            errorLabelDivision.addStyleName("serverResponseLabelError");
            errorLabelDivision.setText("Format incorect");
            return;
        }
    }
}
