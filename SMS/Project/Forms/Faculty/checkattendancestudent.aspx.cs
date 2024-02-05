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

public partial class Forms_Faculty_checkattendancedate : System.Web.UI.Page
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

        OleDbCommand cmd = new OleDbCommand("select id,cdate from Attendance where sid=@sid and status=@status");
        cmd.Parameters.AddWithValue("@sid", txtid.Text);
        cmd.Parameters.AddWithValue("@status", txtenterstatus.Text);
        DataTable dt = dal.getData(cmd);

        
        string status = txtenterstatus.Text;
        if (status == "p" || status == "P")
        {
            lblclass.Text = "Present Days";

        }
        else if (status == "a" || status == "A")
        {
            lblclass.Text = "Absent Days";

        }
        GridView1.DataSource = dt;
        GridView1.DataBind();
        


    }

}