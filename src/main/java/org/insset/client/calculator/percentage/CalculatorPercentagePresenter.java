package org.insset.client.calculator.percentage;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.*;
import org.insset.client.message.dialogbox.DialogBoxInssetPresenter;
import org.insset.client.service.PercentageConverterService;
import org.insset.client.service.PercentageConverterServiceAsync;
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
public class CalculatorPercentagePresenter extends Composite {

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


    interface MainUiBinder extends UiBinder<HTMLPanel, CalculatorPercentagePresenter> { }

    private static CalculatorPercentagePresenter.MainUiBinder ourUiBinder = GWT.create(CalculatorPercentagePresenter.MainUiBinder.class);
    /**
     * Create a remote service proxy to talk to the server-side Greeting
     * service.
     */
    private final PercentageConverterServiceAsync service = GWT.create(PercentageConverterService.class);

    /**
     * Constructeur
     */
    public CalculatorPercentagePresenter() {
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
       
    }

    /**
     * Call server
     */
    private void calculateFinalPrice() {
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
                        "Calculate the final price",
                        "Price before discount: " + priceBeforeDiscountValue + ", Discount percentage: " + discountPercentage1Value,
                        "Price after discount: " + result[0] + ", Discount amount: " + result[1]
                );
            }
        });
    }

    /**
     * Call server
     */
    private void calculateBasePrice() {
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
                        "Calculate the base price",
                        "Price after discount: " + finalPriceValue + ", Discount percentage: " + discountPercentage2Value,
                        "Price before discount: " + result[0] + ", Discount amount: " + result[1]
                );
            }
        });
    }

    /**
     * Call server
     */
    private void divide() {
     
    }
}
