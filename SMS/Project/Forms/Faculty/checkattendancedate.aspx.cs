using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.OleDb;
using DataAccessLayer;
using Microsoft.VisualBasic;

public partial class Forms_Faculty_checkattendancestudent : System.Web.UI.Page
{

    DAL dal = DAL.GetInstance;
    protected void Page_Load(object sender, EventArgs e)
    {
        if ((!IsPostBack))
        {
        }
    }
    protected void btnfind_Click(object sender, EventArgs e)
    {
       
        OleDbCommand cmd = new OleDbCommand("select sid,name from Attendance where cdate=@cdate and status=@status");
        cmd.Parameters.AddWithValue("@cdate",txtenterdate.Text);
        cmd.Parameters.AddWithValue("@status", txtenterstatus.Text);
        DataTable dt = dal.getData(cmd);
        string status = txtenterstatus.Text;
        if (status == "p" || status == "P")
        {
            lblclass.Text = "Present Students of :Class-" + Convert.ToString(Session["class"]);

        }
        else if(status=="a" || status=="A")
        {
            lblclass.Text = "Absent Students of :Class-" + Convert.ToString(Session["class"]);

        }
        GridView1.DataSource = dt;
        GridView1.DataBind();


    }


    protected void Calendar1_SelectionChanged(object sender, EventArgs e)
    {

        txtenterdate.Text = Calendar1.SelectedDate.ToString();

    }

    protected void present_SelectedIndexChanged(object sender, EventArgs e)
    {


    }

    protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}




