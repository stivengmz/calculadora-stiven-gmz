package com.example.calculadora;

import android.support.v7.app.ActionBarActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

		private EditText _edit;
		private Button _b1;
		private Button _b2;
		private Button _b3;
		private Button _b4;
		private Button _b5;
		private Button _b6;
		private Button _b7;
		private Button _b8;
		private Button _b9;
		private Button _b0;
		private Button _bMas;
		private Button _bMenos;
		private Button _bMultiplicar;
		private Button _bDividir;
		private Button _bIgual;
		private Button _bC;
		
		private Button _bSen;
		private Button _bCos;
		private Button _bTan;
	    private Button _bLn;
	    private Button _bFi;
	    private Button _bRaiz;
	    private Button _bExp;
	    private Button _bPorciento;
		
		private double _valor;
		private double _valor2;
		private int _operacion;
		
		private boolean _nuevoValor = true;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) 
	    {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);
	        
	        _valor = 0;
	        _valor2 = 0;
	        
	        _edit = (EditText)findViewById(R.id.editTextos);
	        _b0 = (Button)findViewById(R.id.button0);
	        _b1 = (Button)findViewById(R.id.button1);
	        _b2 = (Button)findViewById(R.id.button2);
	        _b3 = (Button)findViewById(R.id.button3);
	        _b4 = (Button)findViewById(R.id.button4);
	        _b5 = (Button)findViewById(R.id.button5);
	        _b6 = (Button)findViewById(R.id.button6);
	        _b7 = (Button)findViewById(R.id.button7);
	        _b8 = (Button)findViewById(R.id.button8);
	        _b9 = (Button)findViewById(R.id.button9);
	        _bMas = (Button)findViewById(R.id.buttonMas);
	        _bMenos = (Button)findViewById(R.id.buttonResta);
	        _bMultiplicar = (Button)findViewById(R.id.buttonMultiplicar);
	        _bDividir = (Button)findViewById(R.id.buttonDividir);
	        _bIgual = (Button)findViewById(R.id.buttonIgual);
	        _bC = (Button)findViewById(R.id.buttonC);
	        
	        _bSen = (Button)findViewById(R.id.buttonSen);
	        _bCos = (Button)findViewById(R.id.buttonCos);
	        _bTan = (Button)findViewById(R.id.buttonTan);
	        _bLn = (Button)findViewById(R.id.buttonLn);
	        _bFi = (Button)findViewById(R.id.buttonFi);
	        _bRaiz = (Button)findViewById(R.id.buttonRaiz);
	        _bExp = (Button)findViewById(R.id.buttonExp);
	        _bPorciento = (Button)findViewById(R.id.buttonPorciento);
	        
	        
	        
	        _edit.setText("0");
	        
	        View.OnClickListener lsBoton = new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					_edit.setTextColor(Color.BLACK);
					cambiaValor();
					_edit.setText(_edit.getText()+((Button)arg0).getText().toString());
				}
			};
			
			View.OnClickListener lsBotonOperacion = new View.OnClickListener() {
					
				@Override
				public void onClick(View arg0) {
					opera();
					_operacion = 0;
					_nuevoValor = true;
					String text = ((Button)arg0).getText().toString();
					if (text.equals("+")) _operacion = 0;
					if (text.equals("-")) _operacion = 1;
					if (text.equals("*")) _operacion = 2;
					if (text.equals("/")) _operacion = 3;
					if (text.equals("=")) _operacion = -1;
					if (text.equals("Sen"))_operacion = 4;
					if (text.equals("Cos"))_operacion = 5;
					if (text.equals("Tan"))_operacion = 6;
					if (text.equals("Log"))_operacion = 7;
					if (text.equals("Phi"))_operacion = 8;
					if (text.equals("√"))_operacion = 9;
					if (text.equals("Exp"))_operacion = 10;
					if (text.equals("%"))_operacion = 11;
					
					
				}
			};
	        
			_b1.setOnClickListener(lsBoton);        
			_b2.setOnClickListener(lsBoton);
			_b3.setOnClickListener(lsBoton);
			_b4.setOnClickListener(lsBoton);
			_b5.setOnClickListener(lsBoton);
			_b6.setOnClickListener(lsBoton);        
			_b7.setOnClickListener(lsBoton);
			_b8.setOnClickListener(lsBoton);
			_b9.setOnClickListener(lsBoton);
			_b0.setOnClickListener(lsBoton);
					
			_bMas.setOnClickListener(lsBotonOperacion);
			_bMenos.setOnClickListener(lsBotonOperacion);
			_bMultiplicar.setOnClickListener(lsBotonOperacion);
			_bDividir.setOnClickListener(lsBotonOperacion);
			_bIgual.setOnClickListener(lsBotonOperacion);

			_bSen.setOnClickListener(lsBotonOperacion);
			_bCos.setOnClickListener(lsBotonOperacion);
			_bTan.setOnClickListener(lsBotonOperacion);
			_bLn.setOnClickListener(lsBotonOperacion);
			
			_bFi.setOnClickListener(lsBotonOperacion);
			_bRaiz.setOnClickListener(lsBotonOperacion);
			_bExp.setOnClickListener(lsBotonOperacion);
			_bPorciento.setOnClickListener(lsBotonOperacion);

	        
	        _bC.setOnClickListener(new View.OnClickListener() {
		
	        	@Override
	        	public void onClick(View arg0) {
					_edit.setText("0");
					_nuevoValor = true;
					_operacion = -1;
				}
			});
	       
	    }
	    
	    private void cambiaValor()
	    {
	    	if (_nuevoValor == true)
	    	{
	    		_edit.setText("");
	    		_nuevoValor = false;
	    	}
	    }
	    
	    private void opera()
	    {  	
	    	switch (_operacion)
	    	{
	    	case -1: //  Igual
	    		_valor = Integer.parseInt(_edit.getText().toString());
	    		break;
			case 0:	// suma
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = _valor + Integer.parseInt(_edit.getText().toString());
					_edit.setText(String.valueOf(_valor));
				}
				catch (Exception e)
				{
					
				}
				break;
				
			case 1:	// resta
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = _valor - Integer.parseInt(_edit.getText().toString());
					_edit.setText(String.valueOf(_valor));
				}
				catch (Exception e)
				{
					
				}
				break;
			case 2:	// multiplicar
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = _valor * Integer.parseInt(_edit.getText().toString());
					_edit.setText(String.valueOf(_valor));
				}
				catch (Exception e)
				{
					
				}
				break;
				
			case 3:	// dividir
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = _valor / Integer.parseInt(_edit.getText().toString());
					_edit.setText(String.valueOf(_valor));
				}
				catch (Exception e)
				{
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 4:	// Seno
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = Float.parseFloat(_edit.getText().toString()); 
                    _edit.setText(String.valueOf(Math.sin(_valor)));
		    		

					
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 5:	// Coseno
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = Float.parseFloat(_edit.getText().toString()); 
                    _edit.setText(String.valueOf(Math.cos(_valor)));
		    		

					
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 6:	// Tangente
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = Float.parseFloat(_edit.getText().toString()); 
                    _edit.setText(String.valueOf(Math.tan(_valor)));
		    		

					
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 7:	// Logaritmo
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = Float.parseFloat(_edit.getText().toString()); 
                    _edit.setText(String.valueOf(Math.log10(_valor)));
		    		

					
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 8:	// Phi
				try
				{ 
					_edit.setTextColor(Color.BLACK);
					_edit.setText(String.valueOf(Math.PI));
					_valor = Float.parseFloat(_edit.getText().toString());
		    		

					
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 9:	// Raiz
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = Float.parseFloat(_edit.getText().toString()); 
                    _edit.setText(String.valueOf(Math.sqrt(_valor)));
		    		

					
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 10:	// Exponencial
				try
				{
					_edit.setTextColor(Color.BLACK);
                    _edit.setText(String.valueOf(Math.exp(1.0)));

                    _valor = Float.parseFloat(_edit.getText().toString());
             	
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			case 11:	// Porcentaje
				try
				{
					_edit.setTextColor(Color.BLACK);
					_valor = _valor * Integer.parseInt(_edit.getText().toString())/100.0;
					_edit.setText(String.valueOf(_valor));
				}
				catch (Exception e)
				{ 	
					_edit.setTextColor(Color.RED);
					_edit.setText("Err");
				}
				break;
			}
	    		
	    }
	}


