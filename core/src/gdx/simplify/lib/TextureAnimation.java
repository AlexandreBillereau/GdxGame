package gdx.simplify.lib;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.mygdx.game.Context;

import java.io.File;

public class TextureAnimation{
  public SpriteBatch batch;
  public TextureRegion frame;
  public TextureRegion[] regions;
  public Animation<TextureRegion> animation;
  float scale = 1;

  private int posX, posY;

  public TextureAnimation(String relative_path, int tileWidth, int tileHeight, float frameDuration, int x, int y){
    batch =  new SpriteBatch();
    regions = TextureRegion.split(new Texture(relative_path), tileWidth, tileHeight)[0];
    animation = new Animation<>(frameDuration, regions);
    setPosXY(x,y);
  }

  public TextureAnimation(String relative_path, int tileWidth, int tileHeight, float frameDuration, int x, int y, float scale){
    batch =  new SpriteBatch();
    regions = TextureRegion.split(new Texture(relative_path), tileWidth, tileHeight)[0];
    animation = new Animation<>(frameDuration, regions);
    setPosXY(x,y);
    this.scale = scale;
  }

  public TextureAnimation(File directory,float frameDuration, int x , int y, float scale){
    batch =  new SpriteBatch();
    String[] pathname = directory.list();
    regions = new TextureRegion[pathname.length];
    for(int i = 0; i < pathname.length; i++){
      regions[i] = new TextureRegion(new Texture(directory.getPath() + "\\" + pathname[i]));

    }
    animation = new Animation<>(frameDuration, regions);
    setPosXY(x, y);
    this.scale = scale;
  }

  public void draw(float elapse){
    batch.setProjectionMatrix(Context.camera.combined);
    batch.begin();
    frame = animation.getKeyFrame(elapse, true);
    batch.draw(frame, posX, posY, frame.getRegionWidth()*scale,frame.getRegionHeight()*scale);
    batch.end();
  }

  public void draw_uniq(float elapse){
    batch.begin();
    batch.draw(animation.getKeyFrame(elapse), posX, posY, 100*scale,100);
    batch.end();
  }

  public void flip(boolean right_left, boolean up_down){
    int widthFrame = regions[0].getRegionWidth();
    for(TextureRegion x : regions) x.flip(right_left, up_down);

    setPosXY(posX - (widthFrame*2), posY);

  }

  public void update(GdxFunction func){
    func.apply();
  }

  public void setPosXY(int x, int y){
    this.posX  = x;
    this.posY  = y;
  }

  public int width(){
    return animation.getKeyFrame(0).getRegionWidth();
  }

  public int height(){
    return animation.getKeyFrame(0).getRegionHeight();
  }

  public boolean isAnimationFinished(float delta){
    return animation.isAnimationFinished(delta);
  }

  public void playMode(Animation.PlayMode mode){
    animation.setPlayMode(mode);
  }




}
