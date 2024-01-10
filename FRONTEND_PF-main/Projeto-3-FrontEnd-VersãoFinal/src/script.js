const ctx = document.getElementById('myChart');
var months = ['Jan/2023', 'Fev/2023', 'Mar/2023', 'Abr/2023', 'Mai/2023', 'Jun/2023']
var traffic = [5000,  30000, 10000, 15000, 45000, 20000, 25000, 30000, 35000, 40000,  50000, 55000, 60000,]
new Chart(ctx, {
      type: 'line', 
      data: {
      labels: months,
      datasets: [{
      data: traffic,
      borderColor: 'red', 
      backgroundColor: '#ffb5b0',
      borderWidth: 6,
      fill: true ,
      
      }]
      },
      options:{
          animations: {
          tension: {
              duration: 1000,
              easing: 'linear',
              from: 1,
              to: 0,
              loop: true
          }},
        legend: {display: false}, 
        scales:{
            yAxes: [{ticks: {min: 0}}] 
          }
      } 
    });