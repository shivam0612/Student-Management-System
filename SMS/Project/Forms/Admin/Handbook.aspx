<%@ Page Title="" Language="C#" MasterPageFile="~/Forms/Masters/Admin.master" AutoEventWireup="true" CodeFile="Handbook.aspx.cs" Inherits="Forms_Admin_Handbook" %>

<asp:Content ID="Content1" ContentPlaceHolderID="AdminHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="AdminBody" runat="Server">

    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Select Option    

         <br />
        <hr />
    </div>
    <div class="col-md-2"></div>
    <div class="col-md-4">
        <span class="glyphicon glyphicon-user strong" style="font-size: x-large">
            <a href="Createhandbook.aspx">Insert the new Handbook</a>
        </span>
    </div>
    <div class="col-md-4">
        <span class="glyphicon glyphicon-time strong" style="font-size: x-large">
            <a href="ViewHandbook.aspx">View the Handbooks</a>
        </span>
    </div>

    <div class="col-md-1"></div>
</asp:Content>

