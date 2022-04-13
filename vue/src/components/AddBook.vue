<template>
    <div class="add-book">
    <h1 class="title">BookShelf</h1>
    <h3 class="subtext">Let's go on a reading adventure!</h3>
<table class="bookshelf" >
    <thead class='table-header'>
    <tr class='header-row'>
        <th>Current Books</th>
        <th>Books To-read</th>
        <th>Books Read</th>
    </tr>
  </thead>
  <tbody>
    <tr class='table-row'>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr class='table-row'>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <tr class='table-row'>
        <td></td>
        <td></td>
        <td></td>
    </tr>
  </tbody>
</table>
      
<div class='buttons'>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Add New Book
      </button>
    <button class="btn btn-lg btn-primary btn-block" type="submit">
        Move Book
      </button>
</div>

  </div>
</template>

<script>
export default {

}
</script>

<style>
.buttons{
    text-align: center;
}
.bookshelf{
    width:100%
}
.table-header{
    color:darkblue;
}
.header-row{
    height:30px;
}
table, th, td {
  border: 1px solid black;
}

</style>