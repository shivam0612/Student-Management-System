<%@ Page Title="" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="checkattendance.aspx.cs" Inherits="Forms_Faculty_checkattendance" %>

<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Check  Attendance 

         <br />
        <hr />
    </div>
    <div class="col-md-3"></div>
    <div class="col-md-3">
        <span class="glyphicon glyphicon-user strong" style="font-size: x-large">
            <a href="/Forms/Faculty/checkattendancestudent.aspx">Student</a>
        </span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div class="col-md-3">
        <span class="glyphicon glyphicon-time strong" style="font-size: x-large">
            <a href="/Forms/Faculty/checkattendancedate.aspx">Date</a>
        </span>
    </div>

    <div class="col-md-3"></div>

</asp:Content>

