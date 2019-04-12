package sweProject.facade;

public class DetermineType implements Determine{

	@Override
	public String determineFormat(String content) {
		if(content.contains("<")) {
			content = content.substring(content.indexOf('<'),content.length());
			
			if(content.contains(">")) {
				content = content.substring(content.indexOf('>'),content.length());
				
				if(content.contains("<")) {
					content = content.substring(content.indexOf('<'),content.length());
					if(content.contains("/")) {
						content = content.substring(content.indexOf('<'),content.length());
						if(content.contains(">")) {
							content = content.substring(content.indexOf('<'),content.length());
							return "HTML";
						}
					}
					
				}
				
			}
		}
		
		return "TEXT";
	}

	
}