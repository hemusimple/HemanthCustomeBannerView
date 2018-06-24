# HemanthCustomeBannerView
 Its a very simple bannerview ,
 setup instructions
 add these  in project-level gradle file 
 	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
add these in app-level gradle file
	dependencies {
	        implementation 'com.github.hemusimple:HemanthCustomeBannerView:174b864697'
	}

after adding those lines 
now the last step is intializing bannerview 

 com.hemanthkumar.hemanthcustomebannerview.customebanners.CustomeBanner customeBanner = new com.hemanthkumar.hemanthcustomebannerview.customebanners.CustomeBanner(this);
        ArrayList<String> imagepaths = new ArrayList<>();
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528921273.jpg");
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528920939.jpg");
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528921273.jpg");
        imagepaths.add("https://dev.danden.com/uploads/songs/jun2018/1528920939.jpg");
        customeBanner.setAllImages(imagepaths); 	