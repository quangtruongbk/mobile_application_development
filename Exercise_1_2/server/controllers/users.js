var express = require('express')
, router = express.Router();

router.get('/:lat1/:long1/:lat2/:long2',function(req,res){
	//var student_obj = 
	var lat1 = req.params.lat1,
	lat2 = req.params.lat2,
	long1=req.params.long1,
	long2=req.params.long2;

	var result=getDistanceFromLatLonInKm(lat1,long1,lat2,long2);
	// return f;
  // 	return res.send(f);
  res.end(JSON.stringify({Distance: result}));
});

function getDistanceFromLatLonInKm(lat1,lon1,lat2,lon2) {
  var R = 6371; // Radius of the earth in km
  var dLat = deg2rad(lat2-lat1);  // deg2rad below
  var dLon = deg2rad(lon2-lon1); 
  var a = 
  Math.sin(dLat/2) * Math.sin(dLat/2) +
  Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * 
  Math.sin(dLon/2) * Math.sin(dLon/2)
  ; 
  var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a)); 
  var d = R * c; // Distance in km
  return d;
}

function deg2rad(deg) {
	return deg * (Math.PI/180)
}
module.exports = router;