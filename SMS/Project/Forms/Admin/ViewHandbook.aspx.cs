using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.OleDb;
using Microsoft.VisualBasic;
using DataAccessLayer;

public partial class Forms_Admin_ViewHandbook : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;

    protected void Page_Load(object sender, EventArgs e)
    {
        int i = 0;
        OleDbCommand cmd = new OleDbCommand("Select class,handbook from [Handbook]");
        DataTable dt = dal.getData(cmd);

        while (i < dt.Rows.Count)
        {
            if (i % 2 == 0)
            {
                LinkButton b = new LinkButton();
                b.Text = dt.Rows[i]["class"].ToString();
                b.Height = 50;
                b.Width = 200;
                b.Attributes["style"] = "color:blue;text-align: center;    font-size: 40px;margin-left:10px;";
                b.CommandArgument = dt.Rows[i]["handbook"].ToString();
                b.Click += new EventHandler(Clicked);
                this.Form.Controls.Add(b);

                i++;
            }
            else
            {
                LinkButton b = new LinkButton();
                b.Text = dt.Rows[i]["class"].ToString();
                b.Width = 200;
                b.Height = 50;
                b.Attributes["style"] = "text-align: center;font-size: 40px;margin-left:10px;";
                b.CommandArgument = dt.Rows[i]["handbook"].ToString();
                b.Click += new EventHandler(Clicked);
                b.ForeColor = System.Drawing.Color.White;
                this.Form.Controls.Add(b);

                i++;
            }



        }
    }
    private void Clicked(object sender, EventArgs e)
    {

        LinkButton button = (LinkButton)sender;
        string id = button.CommandArgument;
      


        Response.Redirect(id);
    }

}

