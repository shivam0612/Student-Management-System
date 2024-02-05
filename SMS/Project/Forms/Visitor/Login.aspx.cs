using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using DataAccessLayer;
using System.Data;
using System.Data.OleDb;

using Microsoft.VisualBasic;
public partial class Forms_Visitor_Login : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;
    protected void Page_Load(object sender, EventArgs e)
    {
        Session["id"] = null;
    }

    protected void btnLogin_Click(object sender, EventArgs e)
    {

        OleDbCommand cmd = new OleDbCommand("select id,pass,class from Faculty where email = @email");
        cmd.Parameters.AddWithValue("@email", txtUserName.Text);
        DataTable dt = dal.getData(cmd);


        if (dt.Rows.Count  > 0)
{
if( dt.Rows[0]["id"].ToString() == "1" && txtPassword.Text == dt.Rows[0]["pass"].ToString())
        {
            Session["id"] = dt.Rows[0]["id"].ToString();
            Response.Redirect("/Forms/Admin/Default.aspx");

        }
        else if (txtPassword.Text == dt.Rows[0]["pass"].ToString())
        {
            Session["id"] = dt.Rows[0]["id"].ToString();
            Session["class"] = dt.Rows[0]["class"].ToString();
            int Id = Convert.ToInt32(Session["id"]);

            Response.Redirect("/Forms/Faculty/Home.aspx?Id=" + Id+",class="+Session["class"]);
            
            
        }}
        else
        {

            Interaction.MsgBox("Error");
        }
        


    }
}