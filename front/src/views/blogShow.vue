<template>
  <div class="mainpage">

    <div class="block">
          <el-timeline class="blogcontent">
               <el-timeline-item :timestamp= "blog.created" :key="blog.id" placement="top" v-for="blog in blogs">  
                      <el-card class="box-card">
                          <h4>
                            <router-link :to="{ path: '/blogDetail', query:{blogId:blog.id} }">
                              {{ blog.title }}
                            </router-link>
                          </h4>
                          <p>{{ blog.description }}</p>
                    </el-card>
               </el-timeline-item>
          </el-timeline>   


          <el-pagination class="mpage"
                            background
                            layout="prev, pager, next"
                            :current-dpage="currentPage"
                            :page-size="pageSize"
                            :total="total"
                            @current-change=page>
          </el-pagination>
    </div>  
  </div>

</template>

<script>
  import axios from 'axios'
      
  export default {
    name: "kBlogs.vue",
    data: function () {
      return {
        blogs: [],
        currentPage: 1,
        total: 0,
        pageSize: 5
      };
    },
    created() {  
      this.page(1)
    },
    methods: {
      page(currentPage) {
        console.log("-------------------->"+currentPage)
        const _this = this
        axios.get("/blog/page?currentPage=" + currentPage).then(res => {
          console.log(res)
          _this.blogs = res.data.blogs
          _this.currentPage = res.data.currentPage
          _this.total = res.data.total
          _this.pageSize = res.data.pageSize
        })
      },
      handleSelect(key, keyPath) {
        console.log(key, keyPath);
      }
    }

}
</script>
  


<style scoped>
  
   .block{
    position:absolute;
    left: 15%;         
   }

   .box-card {
        height: 120px;
        width: 900px;
        left:510px;
        right:510px;
  }
 
  .mpage {
        margin: 0 auto;
        text-align: center;
  }

 
</style>
