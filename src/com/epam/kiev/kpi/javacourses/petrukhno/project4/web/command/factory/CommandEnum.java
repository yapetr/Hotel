package com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.factory;

import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.Command;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.CreateRoomClassCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.CreateRoomCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.DeleteRoomClassCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.DeleteRoomCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.DeleteUserCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.LoginCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.LogoutCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.OrderCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.PickUpRoomCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.PriceCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.RegisterCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.RoomClassCatalogCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.RoomsCatalogCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.SetLocale;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.SetPriceListCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.SetRoomCommand;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.UnprocessedOrders;
import com.epam.kiev.kpi.javacourses.petrukhno.project4.web.command.UsersListCommand;


/**
 * 
 * @author Yarolav Petrukhno
 *
 * Enum with all possible commands in application. Creates new objects whch 
 * implements interface Command according to chosen item
 * 
 */

public enum CommandEnum {
    
	LOGIN {
		{
			this.command = new LoginCommand(); 
		}
	},
	LOGOUT{
		{
			this.command = new LogoutCommand();
		}
	},
	ORDER{
		{
			this.command = new OrderCommand();
		}
	},
	UNPROCESSEDORDERS{
		{
			this.command = new UnprocessedOrders();
		}
	},
	PRICE{
		{
			this.command = new PriceCommand();
		}
	},	
	PICKUPROOM{
		{
			this.command = new PickUpRoomCommand();
		}
	},	
	ROOMCLASSCATALOG{
		{
			this.command = new RoomClassCatalogCommand();
		}
	},
	ROOMSCATALOG{
		{
			this.command = new RoomsCatalogCommand();
		}
	},
	SETLOCALE{
		{
			this.command = new SetLocale();
		}
	},
	SETROOM{
		{
			this.command = new SetRoomCommand();
		}
	},		
	CREATEROOMCLASS{
		{
			this.command = new CreateRoomClassCommand();
		}
	},	
	CREATEROOM{
		{
			this.command = new CreateRoomCommand();
		}
	},		
	DELETEROOMCLASS{
		{
			this.command = new DeleteRoomClassCommand();
		}
	},	
	DELETEROOM{
		{
			this.command = new DeleteRoomCommand();
		}
	},	
	DELETEUSER{
		{
			this.command = new DeleteUserCommand();
		}
	},		
	REGISTER{
		{
			this.command = new RegisterCommand();
		}
	},	
	SETPRICELIST{
		{
			this.command = new SetPriceListCommand();
		}
	},		
	USERSLIST{
		{
			this.command = new UsersListCommand();
		}
	}
	;
	
	Command command;
	
	public Command getCurrentCommand(){
		return command;
	}
}
