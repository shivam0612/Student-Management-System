<%@ Page Title="" Theme="theme" Language="C#" MasterPageFile="~/Forms/Masters/Faculty.master" AutoEventWireup="true" CodeFile="weekmks.aspx.cs" Inherits="Forms_Faculty_weekmks" %>

<%@ Register Assembly="AjaxControlToolkit" Namespace="AjaxControlToolkit" TagPrefix="ajaxToolkit" %>

<asp:Content ID="Content1" ContentPlaceHolderID="FacultyHead" runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="FacultyBody" runat="Server">
    <asp:ScriptManager ID="ScriptManager1" runat="server">
    </asp:ScriptManager>
    <div class="col-md-12 TitleCenter40" contenteditable="false">
        Enter Marks : Class- 
        <asp:Label ID="lblclass" name="class_name" runat="server"></asp:Label>
        <br />
        <hr />
    </div>
    <div class="col-md-3"></div>

    <div class="form-group col-md-6">


        <div class="form-group">
            <asp:Label ID="lblid" runat="server" Text="Enter id" AssociatedControlID="txtid" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtid" runat="server" Placeholder="id" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredtxtUserName" runat="server" ErrorMessage="Please enter id" ControlToValidate="txtid" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <asp:Label ID="lblsub" runat="server" Text="Subject" AssociatedControlID="txtsubject" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtsubject" runat="server" Placeholder="Subject" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ErrorMessage="Please enter Subject name" ControlToValidate="txtsubject" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>

        <div class="form-group">
            <asp:Label ID="lblmks" runat="server" Text="Marks" AssociatedControlID="txtmks" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtmks" runat="server" Placeholder="Enter marks" SkinID="txt"></asp:TextBox>
            <asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ErrorMessage="Please enter Subject marks" ControlToValidate="txtmks" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>
        </div>
        <div class="form-group">
            <asp:Label ID="lblenterdate" runat="server" Text="Enter Date" AssociatedControlID="txtenterdate" SkinID="lbl"></asp:Label>
            <asp:TextBox ID="txtenterdate" runat="server" placeholder="enter date in xx-xx-xxxx maner" SkinID="txt"></asp:TextBox>
            <ajaxToolkit:CalendarExtender ID="Calendar1" runat="server" BehaviorID="txtenterdate_CalendarExtender"  Format="dd/MM/yyyy" TargetControlID="txtenterdate"></ajaxToolkit:CalendarExtender>
            <asp:RequiredFieldValidator ID="Requiredvaliddate" runat="server" ErrorMessage="please enter date " ControlToValidate="txtenterdate" Display="Dynamic" ForeColor="Red" Font-Size="Large"></asp:RequiredFieldValidator>

        </div>


        <div class="form-group" style="text-align: center;">
            <asp:Button ID="btnsubmit" runat="server" Text="Submit" SkinID="btn" OnClick="btnsubmit_Click" />
        </div>
    </div>




</asp:Content>

