package com.epam.kiev.kpi.javacourses.petrukhno.project4.resource;

import java.util.ListResourceBundle;

public class Resourses extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
		return contents;		
	}
    
	static final Object[][] contents = {
		{ "billtag.label.order", "Заказ"},
		{ "billtag.label.days", "дни"},
		{ "billtag.label.price", "цена"},
		{ "billtag.label.sum", "сумма"},
		{ "billtag.label.bill", "Счет"},
		{ "order.from", "С"}	,
		{ "order.to", "по"}	,
		{ "order.places", "мест"},
		{ "order.roomClass", "класс"},
		{"user.label.accepted", "Ваш заказ принят"},
		{"user.label.incorrectData","Неправильный ввод данных"}
		
    };
}
