<template>
  <div class="contents">
    <h2>내 정보</h2>
  </div>
</template>

<script>


export default {
    name: "MyInfo",

}
</script>

<style>
@import "@/assets/css/accordianVerticalTap.css";
.container{
    display: flex;
    flex-direction: column;
}

.contents{
    width : 700px;
    height: 600px;
    background-color: #ffffff;
    border-radius: 5px;
    box-shadow: 0 0 5px rgba(0,0,0,.2);
    margin-left : 20px;
}

h1.container-title{
    text-align: center;
    height: 100px;
    padding-left: 200px;
    padding-top: 10px;
}

.list-table{
    border-collapse: collapse;
    width : 100%;
}

.list-table a{
    text-decoration: none;
    color : #000000;
}

.list-table th, .list-table td{
    border-bottom: 1px solid #444444;
    padding: 20px 5px;
}
</style>