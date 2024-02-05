<%@ Page Title="" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="Marks.aspx.cs" Inherits="Forms_Faculty_Marks" %>

<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
     <div class="col-md-12 TitleCenter40" contenteditable="false">
Select Test Type
         <br />
        <hr />
    </div>
        <div class="col-md-3"></div>
    <div class="form-group col-md-6">

        <h5 class="lead"><span class="glyphicon glyphicon-hand-right"></span>&nbsp;&nbsp;   

            <a href="/Forms/Faculty/30mks.aspx">30mks:</a></h5>

            <h5 class="lead"><span class="glyphicon glyphicon-hand-right"></span>&nbsp;&nbsp;   
       
            <a href="/Forms/Faculty/70mks.aspx">70mks:</a></h5>

                 <h5 class="lead"><span class="glyphicon glyphicon-list-alt"></span>&nbsp;&nbsp;   
       
            <a href="/Forms/Faculty/weekmks.aspx">Week test:</a>
            
        </h5>
    </div>
</asp:Content>

