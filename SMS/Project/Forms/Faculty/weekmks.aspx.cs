using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Microsoft.VisualBasic;
using System.Data;
using System.Data.OleDb;
using DataAccessLayer;


public partial class Forms_Faculty_weekmks : System.Web.UI.Page
{
    DAL dal = DAL.GetInstance;
    protected void Page_Load(object sender, EventArgs e)
    {
        lblclass.Text = Convert.ToString(Session["class"]);

    }

    protected void btnsubmit_Click(object sender, EventArgs e)
    {
        lblclass.Text = Convert.ToString(Session["class"]);

        OleDbCommand cmd = new OleDbCommand("Insert into [Marks](sid,subject,marks,class,testdate) values(@sid,@subject,@marks,@class,@testdate)");
        cmd.Parameters.AddWithValue("@sid", txtid.Text);
        cmd.Parameters.AddWithValue("@subject", txtsubject.Text);
        cmd.Parameters.AddWithValue("@Marks", txtmks.Text);
        cmd.Parameters.AddWithValue("@class", lblclass.Text);
        cmd.Parameters.AddWithValue("@testdate", txtenterdate.Text);



        if (dal.Execute(cmd))
        {
            Interaction.MsgBox("Entrer Successfully  ");



        }
        else
        {
            Interaction.MsgBox("Error while Enterig");
        }


    }
}