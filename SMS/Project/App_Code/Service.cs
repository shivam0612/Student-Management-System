using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Data;
using System.Data.OleDb;
using DataAccessLayer;

/// <summary>
/// Summary description for Service
/// </summary>
[WebService(Namespace = "http://tempuri.org/")]
[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
// To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
// [System.Web.Script.Services.ScriptService]
public class Service : System.Web.Services.WebService
{

    DAL dal = DAL.GetInstance;
    private string info = "";

    public Service()
    {
    }

    public object Request { get; private set; }


    [WebMethod]
    public bool Authenticate(string id, string pin)
    {

        string user = id;
        string pass = pin;

        OleDbCommand cmd = new OleDbCommand("select id,name,contact from Student where name=@user and contact=@pass");
        cmd.Parameters.AddWithValue("@user", user);
        cmd.Parameters.AddWithValue("pass", @pass);
        DataTable dt = dal.getData(cmd);


        if (dt.Rows.Count > 0 && dt.Rows[0]["contact"].ToString() == pin)
        {

            return true;
        }
        else
        {
            return false;
        }
    }


    [WebMethod]
    public String viewProfile(string id)
    {
        string user = id;

        OleDbCommand cmd = new OleDbCommand("select * from Student where name = @user");
        cmd.Parameters.AddWithValue("@user", user);

        DataTable dt = dal.getData(cmd);

        DataRow dr = dt.Rows[0];
        info = dr["id"] + "," + dr["name"] + "," + dr["address"] + "," + dr["contact"] + "," + dr["email"] + "," + dr["dob"] + "," + dr["class"];
        return info;
    }


    [WebMethod]
    public String weekmarks(string id)
    {
        string user = id;
        OleDbCommand cmd1 = new OleDbCommand("select name,id from Student where name = @user ");
        cmd1.Parameters.AddWithValue("@user", user);
        DataTable ddt = dal.getData(cmd1);
        DataRow ddr = ddt.Rows[0];
        string marksid = ddr["id"].ToString();


        OleDbCommand cmd = new OleDbCommand("select * from marks where sid = @marksid ");
        cmd.Parameters.AddWithValue("@marksid", marksid);

        DataTable dt = dal.getData(cmd);
        for (int i = 0; i < dt.Rows.Count; i++)
        {
            DataRow dr = dt.Rows[i];
            info += dr["sid"] + "," + dr["subject"] + "," + dr["marks"] + "," + dr["class"] + "," + dr["testdate"] + "#";
        }
        return info;
    }



    [WebMethod]
    public String attendanceweekly(string id)
    {
        string user = id;
        OleDbCommand cmd1 = new OleDbCommand("select name,id from Student where name = @user ");
        cmd1.Parameters.AddWithValue("@user", user);
        DataTable ddt = dal.getData(cmd1);
        DataRow ddr = ddt.Rows[0];
        string marksid = ddr["id"].ToString();


        OleDbCommand cmd = new OleDbCommand("select * from Attendance where sid = @marksid ");
        cmd.Parameters.AddWithValue("@marksid", marksid);

        DataTable dt = dal.getData(cmd);

        for (int i = 0; i < dt.Rows.Count; i++)
        {
            DataRow dr = dt.Rows[i];
            info += dr["sid"] + "," + dr["name"] + "," + dr["status"] + "," + dr["class"] + "," + dr["cdate"] + "#";
        }

        return info;
    }


    [WebMethod]
    public String facultydetail(string id)
    {

        OleDbCommand cmd = new OleDbCommand("select * from Faculty");
        DataTable dt = dal.getData(cmd);

        for (int i = 1; i < dt.Rows.Count; i++)
        {
            DataRow dr = dt.Rows[i];
            info += dr["name"] + "," + dr["contact"] + "," + dr["email"] + "," + dr["class"] + "#";
        }
        return info;
    }





    [WebMethod]
    public String pdfurl(string id)
    {
        string user = id;
        OleDbCommand cmd1 = new OleDbCommand("select name,class from Student where name = @user ");
        cmd1.Parameters.AddWithValue("@user", user);
        DataTable ddt = dal.getData(cmd1);
        DataRow ddr = ddt.Rows[0];
        string clas = ddr["class"].ToString();


        OleDbCommand cmd = new OleDbCommand("select handbook,class from Handbook where class = @clas ");
        cmd.Parameters.AddWithValue("@clas", clas);

        DataTable dt = dal.getData(cmd);
        DataRow dr = dt.Rows[0];

        info = dr["handbook"].ToString();


        return info;
    }

    [WebMethod]
    public String attendance(string id)
    {
        string user = id;
        OleDbCommand cmd = new OleDbCommand("SELECT * FROM Attendance WHERE where CDate(format(cdate,'Short Date')) >= CDate(format(date() - 7, 'Short Date'))");
        cmd.Parameters.AddWithValue("@user", user);

        DataTable dt = dal.getData(cmd);

        for (int i = 0; i < dt.Rows.Count; i++)
        {
            DataRow dr = dt.Rows[i];
            info += dr["ID"] + "," + dr["cdate"] + "," + dr["status"] + "#";

        }

        return info;
    }

}
