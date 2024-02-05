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
public partial class Forms_Faculty_CheckMarks : System.Web.UI.Page
{

    DAL dal = DAL.GetInstance;
    protected void Page_Load(object sender, EventArgs e)
    { 

    }

    protected void btncheck_Click(object sender, EventArgs e)
    {

        OleDbCommand cmd = new OleDbCommand("select testdate,marks from Marks  where sid=@sid and subject=@subject");
        cmd.Parameters.AddWithValue("sid", txtid.Text);
        cmd.Parameters.AddWithValue("subject", txtsubject.Text);
        DataTable dt = dal.getData(cmd);
       
        GridView1.DataSource = dt;
        GridView1.DataBind();



    }
}