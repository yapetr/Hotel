package com.epam.kiev.kpi.javacourses.petrukhno.project4.resource;

import java.util.ListResourceBundle;

public class Resourses extends ListResourceBundle {

	@Override
	public Object[][] getContents() {
		return contents;		
	}
    
	static final Object[][] contents = {
		{ "billtag.label.order", "�����"},
		{ "billtag.label.days", "���"},
		{ "billtag.label.price", "����"},
		{ "billtag.label.sum", "�����"},
		{ "billtag.label.bill", "����"},
		{ "order.from", "�"}	,
		{ "order.to", "��"}	,
		{ "order.places", "����"},
		{ "order.roomClass", "�����"},
		{"user.label.accepted", "��� ����� ������"},
		{"user.label.incorrectData","������������ ���� ������"}
		
    };
}
